package casa.cuotas;

import casa.HistorialInterface;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HistoriaRecienteTest {

    private HistoriaReciente compe;
    private PartidoInterface partido;

    @BeforeEach
    void setUp() {
        OponenteInterface a = mock(OponenteInterface.class);
        OponenteInterface b = mock(OponenteInterface.class);

        partido = mock(PartidoInterface.class);
        when(partido.local()).thenReturn(a);
        when(partido.visitante()).thenReturn(b);

        HistorialInterface historial = mock(HistorialInterface.class);
        when(historial.ultimosNPartidos(a, 10)).thenReturn(Arrays.asList("V", "E", "V", "D", "V", "E", "E", "D", "E", "D"));
        when(historial.ultimosNPartidos(b, 10)).thenReturn(Arrays.asList("V", "E", "V", "V", "V", "D", "V", "V", "E", "V"));
        compe = new HistoriaReciente(historial);
    }

    @Test
    void local() {
        BigDecimal result = compe.local(partido);
        BigDecimal expected = new BigDecimal(0.30, new MathContext(2));
        assertEquals(0, result.compareTo(expected));
    }

    @Test
    void empate() {
        BigDecimal result = compe.empate(partido);
        BigDecimal expected = new BigDecimal(0.30, new MathContext(2));
        assertEquals(0, result.compareTo(expected));
    }

    @Test
    void visitante() {
        BigDecimal result = compe.visitante(partido);
        BigDecimal expected = new BigDecimal(0.70, new MathContext(2));
        assertEquals(0, result.compareTo(expected));
    }
}