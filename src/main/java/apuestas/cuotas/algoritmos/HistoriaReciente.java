package apuestas.cuotas.algoritmos;

import apuestas.IHistorial;
import apuestas.partido.IOponente;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class HistoriaReciente implements IAlgoritmo {

    private IHistorial historial;

    public HistoriaReciente(IHistorial historial) {this.historial = historial;}

    private BigDecimal probabilidadDe(IOponente a, String v){
        List<String> historia = historial.ultimosNPartidos(a, 10);
        return new BigDecimal(historia.stream().filter(r -> r.equals(v)).count())
                .divide(new BigDecimal(historia.size()), 2, RoundingMode.HALF_DOWN);
    }

    @Override
    public BigDecimal local(IOponente a, IOponente b) {
        return probabilidadDe(a, "V");
    }

    @Override
    public BigDecimal empate(IOponente a, IOponente b) {
        return probabilidadDe(a, "E").add(probabilidadDe(b, "E")).divide(new BigDecimal(2), 2, RoundingMode.HALF_DOWN);
    }

    @Override
    public BigDecimal visitante(IOponente a, IOponente b) {
        return probabilidadDe(b, "V");
    }
}
