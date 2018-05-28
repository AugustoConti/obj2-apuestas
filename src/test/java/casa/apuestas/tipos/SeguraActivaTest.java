package casa.apuestas.tipos;

import casa.ITipeable;
import casa.apuestas.Evento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class SeguraActivaTest {

    private TipoApuesta activa;

    @BeforeEach
    void setUp() {
        activa = new SeguraActiva();
    }

    @Test
    void cancelar() {
        Evento evento = mock(Evento.class);
        ITipeable apuesta = mock(ITipeable.class);
        try {
            activa.cancelar(evento, apuesta);
            verify(evento).cancelarApuesta(apuesta);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void reactivar() {
        try {
            activa.reactivar(mock(Evento.class), mock(ITipeable.class));
            fail();
        } catch(Exception e) {
            //e.printStackTrace();
        }
    }

    @Test
    void gananciaAcierto() {
        try {
            Evento evento = mock(Evento.class);
            when(evento.acierto(any(String.class))).thenReturn(true);
            when(evento.cuota(any(String.class))).thenReturn(BigDecimal.ONE);
            assertEquals(0, activa.ganancia(evento, "L", BigDecimal.TEN).compareTo(new BigDecimal(8.5)));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void gananciaNoAcierto() {
        try {
            Evento evento = mock(Evento.class);
            when(evento.acierto(any(String.class))).thenReturn(false);
            assertEquals(0, activa.ganancia(evento, "L", BigDecimal.TEN).compareTo(new BigDecimal(-10)));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}