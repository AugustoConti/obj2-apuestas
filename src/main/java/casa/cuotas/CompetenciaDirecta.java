package casa.cuotas;

import casa.IHistorial;
import casa.partido.IOponente;
import casa.partido.IPartido;

import java.math.BigDecimal;
import java.math.MathContext;

public class CompetenciaDirecta implements IAlgoritmo {

    private IHistorial historial;

    public CompetenciaDirecta(IHistorial historial) {this.historial = historial;}

    private BigDecimal victoriasSobre(IOponente a, IOponente b) {
        return new BigDecimal((double) historial.victoriasDe(a, b) / historial.cantidadEnfrentamientos(a, b),
                new MathContext(2));
    }

    @Override
    public BigDecimal local(IPartido p) {
        return victoriasSobre(p.local(), p.visitante());
    }

    @Override
    public BigDecimal empate(IPartido p) {
        return new BigDecimal((double) historial.empatesEntre(p.local(), p.visitante()) /
                historial.cantidadEnfrentamientos(p.local(), p.visitante()),
                new MathContext(2));
    }

    @Override
    public BigDecimal visitante(IPartido p) {
        return victoriasSobre(p.visitante(), p.local());
    }
}
