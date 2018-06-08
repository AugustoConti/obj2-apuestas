package casa.apuestas.tipos;

import casa.apuestas.Evento;
import casa.apuestas.tipos.segura.SeguraInterface;
import casa.partido.Ganador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SeguraTest {

    private Segura segura;
    private SeguraInterface tipo;

    @BeforeEach
    void setUp() {
        tipo = mock(SeguraInterface.class);
        when(tipo.ganancia(any(Evento.class), any(Ganador.class), any(BigDecimal.class))).thenReturn(BigDecimal.ONE);
        segura = new Segura(tipo);
    }

    @Test
    void cancelar() throws Exception {
        Evento evento = mock(Evento.class);
        segura.cancelar(evento);
        verify(tipo).cancelar(evento, segura);
    }

    @Test
    void reactivar() throws Exception {
        Evento evento = mock(Evento.class);
        segura.reactivar(evento);
        verify(tipo).reactivar(evento, segura);
    }

    @Test
    void ganancia() {
        assertEquals(0, segura.ganancia(mock(Evento.class), Ganador.VISITANTE, BigDecimal.TEN).compareTo(BigDecimal.ONE));
    }

    @Test
    void setTipo() throws Exception {
        SeguraInterface tipo = mock(SeguraInterface.class);
        Evento evento = mock(Evento.class);
        segura.setTipo(tipo);
        segura.cancelar(evento);
        verify(tipo).cancelar(evento, segura);

    }
}