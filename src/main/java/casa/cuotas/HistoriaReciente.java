package casa.cuotas;

import casa.IHistorial;
import casa.partido.IOponente;
import casa.partido.IPartido;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class HistoriaReciente implements IAlgoritmo {

    private IHistorial historial;

    public HistoriaReciente(IHistorial historial) {this.historial = historial;}

    private BigDecimal probabilidadDe(IOponente a, String v) {
        List<String> historia = historial.ultimosNPartidos(a, 10);
        return new BigDecimal(historia.stream().filter(r -> r.equals(v)).count())
                .divide(new BigDecimal(historia.size()), 2, RoundingMode.HALF_DOWN);
    }

    @Override
    public BigDecimal local(IPartido p) {
        return probabilidadDe(p.local(), "V");
    }

    @Override
    public BigDecimal empate(IPartido p) {
        return probabilidadDe(p.local(), "E").add(probabilidadDe(p.visitante(), "E")).divide(new BigDecimal(2), 2, RoundingMode.HALF_DOWN);
    }

    @Override
    public BigDecimal visitante(IPartido p) {
        return probabilidadDe(p.visitante(), "V");
    }
}
