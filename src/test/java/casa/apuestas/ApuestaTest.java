package casa.apuestas;

import casa.apuestas.tipos.TipoApuestaInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ApuestaTest {

    private Apuesta apuesta;
    private Evento evento;
    private TipoApuestaInterface tipo;

    @BeforeEach
    void setUp() {
        evento = mock(Evento.class);
        tipo = mock(TipoApuestaInterface.class);
        apuesta = new Apuesta(BigDecimal.TEN, "L", evento, tipo);
    }

    @Test
    void setTipo() {
        apuesta.setTipo(mock(TipoApuestaInterface.class));
    }

    @Test
    void cancelar() throws Exception {
        apuesta.cancelar();
        verify(tipo).cancelar(evento, apuesta);
    }

    @Test
    void reactivar() throws Exception {
        apuesta.reactivar();
        verify(tipo).reactivar(evento, apuesta);

    }

    @Test
    void gananciaBruta() throws Exception {
        when(evento.terminado()).thenReturn(true);
        when(tipo.ganancia(evento, "L", BigDecimal.TEN)).thenReturn(BigDecimal.ONE);
        assertEquals(0, apuesta.gananciaBruta().compareTo(new BigDecimal(11)));
    }

    @Test
    void gananciaNeta() throws Exception {
        when(evento.terminado()).thenReturn(true);

        when(tipo.ganancia(evento, "L", BigDecimal.TEN)).thenReturn(BigDecimal.ONE);
        assertEquals(0, apuesta.gananciaNeta().compareTo(BigDecimal.ONE));
    }

    @Test
    void gananciaNetaTerminado() {
        when(evento.terminado()).thenReturn(false);

        assertThrows(Exception.class, () -> apuesta.gananciaNeta());
    }

    @Test
    void inMonth() {
        when(evento.inMonth(1)).thenReturn(true);
        assertTrue(apuesta.inMonth(1));
    }
}