package casa.apuestas.tipos;

import casa.apuestas.Evento;
import casa.partido.Ganador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FinalTest {

    private Final fin;

    @BeforeEach
    void setUp() {
        fin = new Final();
    }

    @Test
    void cancelar() {
        assertThrows(Exception.class, () -> fin.cancelar(mock(Evento.class)));
    }

    @Test
    void reactivar() {
        assertThrows(Exception.class, () -> fin.reactivar(mock(Evento.class)));
    }

    @Test
    void gananciaAcierto() {
        Evento evento = mock(Evento.class);
        when(evento.acierto(any(Ganador.class))).thenReturn(true);
        when(evento.cuota(any(Ganador.class))).thenReturn(BigDecimal.ONE);
        assertEquals(0, fin.ganancia(evento, Ganador.VISITANTE, BigDecimal.TEN).compareTo(BigDecimal.TEN));
    }

    @Test
    void gananciaNoAcierto() {
        Evento evento = mock(Evento.class);
        when(evento.acierto(any(Ganador.class))).thenReturn(false);
        assertEquals(0, fin.ganancia(evento, Ganador.VISITANTE, BigDecimal.TEN).compareTo(new BigDecimal(-10)));
    }
}