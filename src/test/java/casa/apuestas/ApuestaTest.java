package casa.apuestas;

import casa.apuestas.tipos.TipoApuestaInterface;
import casa.partido.Ganador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ApuestaTest {

    private Apuesta apuesta;
    private Evento evento;
    private TipoApuestaInterface tipo;

    @BeforeEach
    void setUp() {
        evento = mock(Evento.class);
        tipo = mock(TipoApuestaInterface.class);
        apuesta = new Apuesta(BigDecimal.TEN, Ganador.VISITANTE, evento, tipo);
    }

    @Test
    void cancelar() throws Exception {
        apuesta.cancelar();
        verify(tipo).cancelar(evento);
    }

    @Test
    void reactivar() throws Exception {
        apuesta.reactivar();
        verify(tipo).reactivar(evento);
    }

    @Test
    void gananciaBruta() {
        when(evento.terminado()).thenReturn(true);
        when(tipo.ganancia(evento, Ganador.VISITANTE, BigDecimal.TEN)).thenReturn(BigDecimal.ONE);
        assertEquals(0, apuesta.gananciaBruta().compareTo(new BigDecimal(11)));
    }

    @Test
    void gananciaNeta() {
        when(evento.terminado()).thenReturn(true);
        when(tipo.ganancia(evento, Ganador.VISITANTE, BigDecimal.TEN)).thenReturn(BigDecimal.ONE);
        assertEquals(0, apuesta.gananciaNeta().compareTo(BigDecimal.ONE));
    }

    @Test
    void gananciaNetaTerminado() {
        when(evento.terminado()).thenReturn(false);
        assertEquals(BigDecimal.ZERO, apuesta.gananciaNeta());
    }

    @Test
    void inMonth() {
        when(evento.inMonth(Month.JANUARY)).thenReturn(true);
        assertTrue(apuesta.inMonth(Month.JANUARY));
    }
}