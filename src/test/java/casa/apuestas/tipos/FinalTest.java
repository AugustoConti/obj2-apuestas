package casa.apuestas.tipos;

import casa.ITipeable;
import casa.apuestas.Evento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FinalTest {

    private TipoApuesta fin;

    @BeforeEach
    void setUp() {
        fin = new Final();
    }

    @Test
    void cancelar() {
        try {
            fin.cancelar(mock(Evento.class), mock(ITipeable.class));
            fail();
        } catch(Exception e) {
            //e.printStackTrace();
        }
    }

    @Test
    void reactivar() {
        try {
            fin.reactivar(mock(Evento.class), mock(ITipeable.class));
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
            assertEquals(0, fin.ganancia(evento, "L", BigDecimal.TEN).compareTo(BigDecimal.TEN));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void gananciaNoAcierto() {
        try {
            Evento evento = mock(Evento.class);
            when(evento.acierto(any(String.class))).thenReturn(false);
            assertEquals(0, fin.ganancia(evento, "L", BigDecimal.TEN).compareTo(new BigDecimal(-10)));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}