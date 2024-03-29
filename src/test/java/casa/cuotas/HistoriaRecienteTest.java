package casa.cuotas;

import casa.Historial;
import casa.partido.OponenteInterface;
import casa.partido.Partido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HistoriaRecienteTest {

    private HistoriaReciente compe;
    private Partido partido;

    @BeforeEach
    void setUp() {
        OponenteInterface a = mock(OponenteInterface.class);
        OponenteInterface b = mock(OponenteInterface.class);

        partido = mock(Partido.class);
        when(partido.getLocal()).thenReturn(a);
        when(partido.getVisitante()).thenReturn(b);

        Historial historial = mock(Historial.class);
        when(historial.cantVictoriasEnUltimosNPartidos(a, 10)).thenReturn(3);
        when(historial.cantVictoriasEnUltimosNPartidos(b, 10)).thenReturn(7);
        when(historial.cantEmpatesEnUltimosNPartidos(a, 10)).thenReturn(3);
        when(historial.cantEmpatesEnUltimosNPartidos(b, 10)).thenReturn(3);
        when(historial.cantUltimosNPartidos(a, 10)).thenReturn(10);
        when(historial.cantUltimosNPartidos(b, 10)).thenReturn(10);

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