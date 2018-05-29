package casa.cuotas;

import casa.HistorialInterface;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;

import java.math.BigDecimal;
import java.math.MathContext;

public class CompetenciaDirecta implements AlgortimoInterface {

    private HistorialInterface historial;

    public CompetenciaDirecta(HistorialInterface historial) {this.historial = historial;}

    private BigDecimal victoriasSobre(OponenteInterface a, OponenteInterface b) {
        return new BigDecimal((double) historial.victoriasDe(a, b) / historial.cantidadEnfrentamientos(a, b),
                new MathContext(2));
    }

    @Override
    public BigDecimal local(PartidoInterface p) {
        return victoriasSobre(p.local(), p.visitante());
    }

    @Override
    public BigDecimal empate(PartidoInterface p) {
        return new BigDecimal((double) historial.empatesEntre(p.local(), p.visitante()) /
                historial.cantidadEnfrentamientos(p.local(), p.visitante()),
                new MathContext(2));
    }

    @Override
    public BigDecimal visitante(PartidoInterface p) {
        return victoriasSobre(p.visitante(), p.local());
    }
}
