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

    private Partido p1;
    private Partido p2;
    private Filtrable filtrop1;
    private Filtrable filtrop1bis;
    private Filtrable filtrop2;
    private Filtrable filtroVacio;

    @BeforeEach
    void setUp() {
        p1 = mock(Partido.class);
        filtrop1 = mock(Filtrable.class);
        when(filtrop1.filtrar()).thenReturn(new ArrayList<>(Collections.singletonList(p1)));
        filtrop1bis = mock(Filtrable.class);
        when(filtrop1bis.filtrar()).thenReturn(new ArrayList<>(Collections.singletonList(p1)));

        p2 = mock(Partido.class);
        filtrop2 = mock(Filtrable.class);
        when(filtrop2.filtrar()).thenReturn(new ArrayList<>(Collections.singletonList(p2)));

        filtroVacio = mock(Filtrable.class);
        when(filtroVacio.filtrar()).thenReturn(new ArrayList<>());
    }

    @Test
    void filtrar1deCada() {
        FiltroOR filtro = new FiltroOR(filtrop1, filtrop2);
        List<Partido> resultado = filtro.filtrar();
        assertEquals(2, resultado.size());
        assertTrue(resultado.containsAll(Arrays.asList(p1, p2)));
    }

    @Test
    void filtrar1vacio() {
        FiltroOR filtro = new FiltroOR(filtrop1, filtroVacio);
        List<Partido> resultado = filtro.filtrar();
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(p1));
    }

    @Test
    void filtrarSinRepetidos() {
        FiltroOR filtro = new FiltroOR(filtrop1, filtrop1bis);
        List<Partido> resultado = filtro.filtrar();
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(p1));
    }
}