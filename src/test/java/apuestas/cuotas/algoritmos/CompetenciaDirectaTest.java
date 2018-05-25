package apuestas.cuotas.algoritmos;

import apuestas.IHistorial;
import apuestas.cuotas.algoritmos.competenciaDirecta.CompetenciaDirecta;
import apuestas.partido.IOponente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CompetenciaDirectaTest {

    private CompetenciaDirecta compe;
    private IOponente a;
    private IOponente b;

    @BeforeEach
    void setUp() {
        a = mock(IOponente.class);
        b = mock(IOponente.class);
        IHistorial historial = mock(IHistorial.class);
        when(historial.victoriasDe(a, b)).thenReturn(14);
        when(historial.victoriasDe(b, a)).thenReturn(4);
        when(historial.empatesEntre(any(IOponente.class), any(IOponente.class))).thenReturn(2);
        when(historial.cantidadEnfrentamientos(any(IOponente.class), any(IOponente.class))).thenReturn(20);
        compe = new CompetenciaDirecta(historial);
    }

    @Test
    void local() {
        BigDecimal result = compe.local(a, b);
        BigDecimal expected = new BigDecimal(0.70, new MathContext(2));
        assertTrue(result.compareTo(expected) == 0);
    }

    @Test
    void empate() {
        BigDecimal result = compe.empate(mock(IOponente.class), mock(IOponente.class));
        BigDecimal expected = new BigDecimal(0.10, new MathContext(2));
        assertTrue(result.compareTo(expected) == 0);
    }

    @Test
    void visitante() {
        BigDecimal result = compe.local(b, a);
        BigDecimal expected = new BigDecimal(0.20, new MathContext(2));
        assertTrue(result.compareTo(expected) == 0);
    }
}