package casa.cuotas;

import casa.HistorialInterface;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HistoriaReciente implements CuotaInterface {

    private HistorialInterface historial;
    private static Integer cantUltimosNPartidos = 10;

    public HistoriaReciente(HistorialInterface historial) {this.historial = historial;}

    private BigDecimal probabilidad(int cantidad, int divisor) {
        return new BigDecimal(cantidad).divide(new BigDecimal(divisor), 2, RoundingMode.HALF_DOWN);
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
    public BigDecimal local(PartidoInterface p) {
        return probabilidadVictoriaDe(p.local());
    }

    @Override
    public BigDecimal empate(PartidoInterface p) {
        return probabilidadEmpateDe(p.local())
                .add(probabilidadEmpateDe(p.visitante()))
                .divide(new BigDecimal(2), 2, RoundingMode.HALF_DOWN);
    }

    @Override
    public BigDecimal visitante(PartidoInterface p) {
        return probabilidadVictoriaDe(p.visitante());
    }
}
