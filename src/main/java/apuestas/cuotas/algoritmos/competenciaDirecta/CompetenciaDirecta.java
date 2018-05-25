package apuestas.cuotas.algoritmos.competenciaDirecta;

import apuestas.IHistorial;
import apuestas.cuotas.algoritmos.IAlgoritmo;
import apuestas.partido.IOponente;

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
    public BigDecimal local(IOponente a, IOponente b) {
        return victoriasSobre(a, b);
    }

    @Override
    public BigDecimal empate(IOponente a, IOponente b) {
        return new BigDecimal((double) historial.empatesEntre(a, b) / historial.cantidadEnfrentamientos(a, b),
                new MathContext(2));
    }

    @Override
    public BigDecimal visitante(IOponente a, IOponente b) {
        return victoriasSobre(b, a);
    }
}
