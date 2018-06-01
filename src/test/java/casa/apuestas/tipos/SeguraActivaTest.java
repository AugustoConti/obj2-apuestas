package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SeguraActivaTest {

    private SeguraActiva activa;

    @BeforeEach
    void setUp() {
        activa = new SeguraActiva();
    }

    @Test
    void cancelar() throws Exception {
        Evento evento = mock(Evento.class);
        TipeableInterface apuesta = mock(TipeableInterface.class);
        activa.cancelar(evento, apuesta);
        verify(evento).cancelarApuesta(apuesta);

    }

    @Test
    void reactivar() {
        assertThrows(Exception.class, () -> activa.reactivar(mock(Evento.class), mock(TipeableInterface.class)));
    }

    @Test
    void gananciaAcierto() {

        Evento evento = mock(Evento.class);
        when(evento.acierto(any(Ganador.class))).thenReturn(true);
        when(evento.cuota(any(Ganador.class))).thenReturn(BigDecimal.ONE);
        assertEquals(0, activa.ganancia(evento, Ganador.VISITANTE, BigDecimal.TEN).compareTo(new BigDecimal(8.5)));
    }

    @Test
    void gananciaNoAcierto() {
        Evento evento = mock(Evento.class);
        when(evento.acierto(any(Ganador.class))).thenReturn(false);
        assertEquals(0, activa.ganancia(evento, Ganador.VISITANTE, BigDecimal.TEN).compareTo(new BigDecimal(-10)));

    }
}