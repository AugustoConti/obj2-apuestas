package casa.cuotas;

import casa.Historial;
import casa.partido.OponenteInterface;
import casa.partido.Partido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HistoriaReciente implements CuotaInterface {

    private final Historial historial;
    private final Integer cantUltimosNPartidos = 10;

    HistoriaReciente(Historial historial) {
        this.historial = historial;
    }

    private BigDecimal probabilidad(Integer cantidad, Integer divisor) {
        return BigDecimal.valueOf(cantidad).divide(BigDecimal.valueOf(divisor), 2, RoundingMode.HALF_DOWN);
    }

    private BigDecimal probabilidadVictoriaDe(OponenteInterface oponente) {
        return probabilidad(historial.cantVictoriasEnUltimosNPartidos(oponente, cantUltimosNPartidos),
                historial.cantUltimosNPartidos(oponente, cantUltimosNPartidos));
    }

    private BigDecimal probabilidadEmpateDe(OponenteInterface oponente) {
        return probabilidad(historial.cantEmpatesEnUltimosNPartidos(oponente, cantUltimosNPartidos),
                historial.cantUltimosNPartidos(oponente, cantUltimosNPartidos));
    }

    @Override
    public BigDecimal local(Partido p) {
        return probabilidadVictoriaDe(p.getLocal());
    }

    @Override
    public BigDecimal empate(Partido p) {
        return probabilidadEmpateDe(p.getLocal())
                .add(probabilidadEmpateDe(p.getVisitante()))
                .divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_DOWN);
    }

    @Override
    public BigDecimal visitante(Partido p) {
        return probabilidadVictoriaDe(p.getVisitante());
    }
}
