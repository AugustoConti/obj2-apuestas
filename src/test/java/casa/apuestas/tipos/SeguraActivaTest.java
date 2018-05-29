package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class SeguraActivaTest {

    private TipoApuestaInterface activa;

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
    void gananciaAcierto() throws Exception {

        Evento evento = mock(Evento.class);
        when(evento.acierto(any(String.class))).thenReturn(true);
        when(evento.cuota(any(String.class))).thenReturn(BigDecimal.ONE);
        assertEquals(0, activa.ganancia(evento, "L", BigDecimal.TEN).compareTo(new BigDecimal(8.5)));
    }

    @Test
    void gananciaNoAcierto() throws Exception {
        Evento evento = mock(Evento.class);
        when(evento.acierto(any(String.class))).thenReturn(false);
        assertEquals(0, activa.ganancia(evento, "L", BigDecimal.TEN).compareTo(new BigDecimal(-10)));

    }
}