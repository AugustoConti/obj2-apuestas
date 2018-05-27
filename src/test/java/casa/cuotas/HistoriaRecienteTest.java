package casa.cuotas;

import casa.IHistorial;
import casa.cuotas.HistoriaReciente;
import casa.partido.IOponente;
import casa.partido.IPartido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HistoriaRecienteTest {

    private HistoriaReciente compe;
    private IPartido partido;

    @BeforeEach
    void setUp() {
        IOponente a = mock(IOponente.class);
        IOponente b = mock(IOponente.class);

        partido = mock(IPartido.class);
        when(partido.local()).thenReturn(a);
        when(partido.visitante()).thenReturn(b);

        IHistorial historial = mock(IHistorial.class);
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