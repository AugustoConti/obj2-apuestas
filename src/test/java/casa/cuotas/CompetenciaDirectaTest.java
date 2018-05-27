package casa.cuotas;

import casa.IHistorial;
import casa.cuotas.CompetenciaDirecta;
import casa.partido.IOponente;
import casa.partido.IPartido;
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
    private IPartido partido;

    @BeforeEach
    void setUp() {
        IOponente a = mock(IOponente.class);
        IOponente b = mock(IOponente.class);

        partido = mock(IPartido.class);
        when(partido.local()).thenReturn(a);
        when(partido.visitante()).thenReturn(b);

        IHistorial historial = mock(IHistorial.class);
        when(historial.victoriasDe(a, b)).thenReturn(14);
        when(historial.victoriasDe(b, a)).thenReturn(4);
        when(historial.empatesEntre(any(IOponente.class), any(IOponente.class))).thenReturn(2);
        when(historial.cantidadEnfrentamientos(any(IOponente.class), any(IOponente.class))).thenReturn(20);
        compe = new CompetenciaDirecta(historial);
    }

    @Test
    void local() {
        BigDecimal result = compe.local(partido);
        BigDecimal expected = new BigDecimal(0.70, new MathContext(2));
        assertEquals(0, result.compareTo(expected));
    }

    @Test
    void empate() {
        BigDecimal result = compe.empate(partido);
        BigDecimal expected = new BigDecimal(0.10, new MathContext(2));
        assertEquals(0, result.compareTo(expected));
    }

    @Test
    void visitante() {
        BigDecimal result = compe.visitante(partido);
        BigDecimal expected = new BigDecimal(0.20, new MathContext(2));
        assertEquals(0, result.compareTo(expected));
    }
}