package casa.partido.filtros;

import casa.Historial;
import casa.partido.Partido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FiltroFechaTest {

    private FiltroFecha filtro;
    private List<Partido> lista;

    @BeforeEach
    void setUp() {
        lista = Collections.emptyList();
        LocalDateTime fecha = LocalDateTime.now();
        Historial historial = mock(Historial.class);
        when(historial.partidosCon(fecha)).thenReturn(lista);

        filtro = new FiltroFecha(historial, fecha);
    }

    @Test
    void filtrar() {
        assertEquals(lista, filtro.filtrar());
    }
}