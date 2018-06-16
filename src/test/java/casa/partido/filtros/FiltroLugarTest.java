package casa.partido.filtros;

import casa.Historial;
import casa.partido.Partido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FiltroLugarTest {

    private FiltroLugar filtro;
    private List<Partido> lista;

    @BeforeEach
    void setUp() {
        lista = Collections.emptyList();
        String lugar = "bsas";
        Historial historial = mock(Historial.class);
        when(historial.partidosCon(lugar)).thenReturn(lista);

        filtro = new FiltroLugar(historial, lugar);
    }

    @Test
    void filtrar() {
        assertEquals(lista, filtro.filtrar());
    }
}