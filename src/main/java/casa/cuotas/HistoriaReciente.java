package casa.cuotas;

import casa.HistorialInterface;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class HistoriaReciente implements AlgortimoInterface {

    private HistorialInterface historial;

    public HistoriaReciente(HistorialInterface historial) {this.historial = historial;}


    /* */
    private BigDecimal probabilidadDe(OponenteInterface a, String v) {

        /* Define la cantidad de partidos que se va a usar en el historial*/
        Integer cantUltimosNPartidos = 10;

        List<String> historia = historial.ultimosNPartidos(a, cantUltimosNPartidos);
        return new BigDecimal(historia.stream().filter(r -> r.equals(v)).count())
                .divide(new BigDecimal(historia.size()), 2, RoundingMode.HALF_DOWN);
    }

    /* */
    @Override
    public BigDecimal local(PartidoInterface p) {
        return probabilidadDe(p.local(), "V");
    }

    /* */
    @Override
    public BigDecimal empate(PartidoInterface p) {
        return probabilidadDe(p.local(), "E").add(probabilidadDe(p.visitante(), "E")).divide(new BigDecimal(2), 2, RoundingMode.HALF_DOWN);
    }

    /* */
    @Override
    public BigDecimal visitante(PartidoInterface p) {
        return probabilidadDe(p.visitante(), "V");
    }
}
