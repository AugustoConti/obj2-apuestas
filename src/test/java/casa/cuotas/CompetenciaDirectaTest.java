package casa.cuotas;

import casa.HistorialInterface;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;
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
    private PartidoInterface partido;

    @BeforeEach
    void setUp() {
        OponenteInterface a = mock(OponenteInterface.class);
        OponenteInterface b = mock(OponenteInterface.class);

        partido = mock(PartidoInterface.class);
        when(partido.local()).thenReturn(a);
        when(partido.visitante()).thenReturn(b);

        HistorialInterface historial = mock(HistorialInterface.class);
        when(historial.victoriasDe(a, b)).thenReturn(14);
        when(historial.victoriasDe(b, a)).thenReturn(4);
        when(historial.empatesEntre(any(OponenteInterface.class), any(OponenteInterface.class))).thenReturn(2);
        when(historial.cantidadEnfrentamientos(any(OponenteInterface.class), any(OponenteInterface.class))).thenReturn(20);
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