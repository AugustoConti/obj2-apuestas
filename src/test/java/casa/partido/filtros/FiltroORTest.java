package casa.partido.filtros;

import casa.partido.Partido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FiltroORTest {

    private FiltroOR filtro;
    private Partido p1;
    private Partido p2;

    @BeforeEach
    void setUp() {
        p1 = mock(Partido.class);
        FiltroInterface filtroL = mock(FiltroInterface.class);
        when(filtroL.filtrar()).thenReturn(new ArrayList<>(Collections.singletonList(p1)));

        p2 = mock(Partido.class);
        FiltroInterface filtroR = mock(FiltroInterface.class);
        when(filtroR.filtrar()).thenReturn(new ArrayList<>(Collections.singletonList(p2)));

        filtro = new FiltroOR(filtroL, filtroR);
    }

    @Test
    void filtrar() {
        List<Partido> resultado = filtro.filtrar();
        assertEquals(2, resultado.size());
        assertTrue(resultado.containsAll(Arrays.asList(p1, p2)));
    }
}