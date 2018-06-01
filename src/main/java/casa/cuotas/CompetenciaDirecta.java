package casa.cuotas;

import casa.HistorialInterface;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompetenciaDirecta implements CuotaInterface {

    private HistorialInterface historial;

    public CompetenciaDirecta(HistorialInterface historial) {this.historial = historial;}

    /**
     * Calcula la probabilidad de victorias del oponente a sobre el b en la cantidad de partidos que se enfrentaron
     */
    private BigDecimal porcentajeVictorias(OponenteInterface a, OponenteInterface b) {
        return BigDecimal.valueOf(historial.cantVictoriasDe(a, b))
                .divide(BigDecimal.valueOf(historial.cantidadEnfrentamientos(a, b)),
                        2, RoundingMode.HALF_DOWN);
    }

    /**
     * Probabilidad de victorias del equipo local sobre el visitante
     */
    @Override
    public BigDecimal local(PartidoInterface p) {
        return porcentajeVictorias(p.local(), p.visitante());
    }

    /**
     * Calcula la probabilidad de empates del oponente a sobre el b en la cantidad de partidos que se enfrentaron
     */
    @Override
    public BigDecimal empate(PartidoInterface p) {
        return BigDecimal.valueOf(historial.cantEmpatesEntre(p.local(), p.visitante()))
                .divide(BigDecimal.valueOf(historial.cantidadEnfrentamientos(p.local(), p.visitante())),
                        2, RoundingMode.HALF_DOWN);
    }

    /**
     * Probabilidad de victorias del equipo local sobre el visitante
     */
    @Override
    public BigDecimal visitante(PartidoInterface p) {
        return porcentajeVictorias(p.visitante(), p.local());
    }
}
