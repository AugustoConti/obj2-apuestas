package casa.partido.filtros;

import casa.Historial;
import casa.partido.Deporte;
import casa.partido.Partido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FiltroDeporteTest {

    private FiltroDeporte filtro;
    private List<Partido> lista;

    @BeforeEach
    void setUp() {
        lista = Collections.emptyList();
        Deporte deporte = mock(Deporte.class);
        Historial historial = mock(Historial.class);
        when(historial.partidosCon(deporte)).thenReturn(lista);

        filtro = new FiltroDeporte(historial, deporte);
    }

    @Test
    void filtrar() {
        assertEquals(lista, filtro.filtrar());
    }
}