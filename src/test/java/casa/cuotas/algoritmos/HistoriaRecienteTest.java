package casa.cuotas.algoritmos;

import casa.IHistorial;
import casa.cuotas.HistoriaReciente;
import casa.partido.IOponente;
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
    private IOponente a;
    private IOponente b;

    @BeforeEach
    void setUp() {
        a = mock(IOponente.class);
        b = mock(IOponente.class);
        IHistorial historial = mock(IHistorial.class);
        when(historial.ultimosNPartidos(a, 10)).thenReturn(Arrays.asList("V", "E", "V", "D", "V", "E", "E", "D", "E", "D"));
        when(historial.ultimosNPartidos(b, 10)).thenReturn(Arrays.asList("V", "E", "V", "V", "V", "D", "V", "V", "E", "V"));
        compe = new HistoriaReciente(historial);
    }

    @Test
    void local() {
        BigDecimal result = compe.local(a, b);
        BigDecimal expected = new BigDecimal(0.30, new MathContext(2));
        assertTrue(result.compareTo(expected) == 0);
    }

    @Test
    void empate() {
        BigDecimal result = compe.empate(a, b);
        BigDecimal expected = new BigDecimal(0.30, new MathContext(2));
        assertTrue(result.compareTo(expected) == 0);
    }

    @Test
    void visitante() {
        BigDecimal result = compe.visitante(a, b);
        BigDecimal expected = new BigDecimal(0.70, new MathContext(2));
        assertTrue(result.compareTo(expected) == 0);
    }
}