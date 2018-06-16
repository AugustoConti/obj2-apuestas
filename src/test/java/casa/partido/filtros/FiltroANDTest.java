package casa.partido.filtros;

import casa.partido.Partido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FiltroANDTest {

    private FiltroAND filtro;
    private Partido p;

    @BeforeEach
    void setUp() {
        p = mock(Partido.class);

        Partido p1 = mock(Partido.class);
        FiltroInterface filtroL = mock(FiltroInterface.class);
        when(filtroL.filtrar()).thenReturn(new ArrayList<>(Arrays.asList(p1, p)));

        Partido p2 = mock(Partido.class);
        FiltroInterface filtroR = mock(FiltroInterface.class);
        when(filtroR.filtrar()).thenReturn(new ArrayList<>(Arrays.asList(p, p2)));

        filtro = new FiltroAND(filtroL, filtroR);
    }

    @Test
    void filtrar() {
        List<Partido> resultado = filtro.filtrar();
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(p));
    }
}