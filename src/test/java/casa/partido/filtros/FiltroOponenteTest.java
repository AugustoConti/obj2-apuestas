package casa.partido.filtros;

import casa.Historial;
import casa.partido.OponenteInterface;
import casa.partido.Partido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FiltroOponenteTest {

    private FiltroOponente filtro;
    private List<Partido> lista;

    @BeforeEach
    void setUp() {
        lista = Collections.emptyList();
        OponenteInterface oponente = mock(OponenteInterface.class);
        Historial historial = mock(Historial.class);
        when(historial.partidosCon(oponente)).thenReturn(lista);

        filtro = new FiltroOponente(historial, oponente);
    }

    @Test
    void filtrar() {
        assertEquals(lista, filtro.filtrar());
    }
}