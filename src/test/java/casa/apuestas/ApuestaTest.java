package casa.apuestas;

import casa.apuestas.tipos.TipoApuesta;
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
    private TipoApuesta tipo;

    @BeforeEach
    void setUp() {
        evento = mock(Evento.class);
        tipo = mock(TipoApuesta.class);
        apuesta = new Apuesta(BigDecimal.TEN, "L", evento, tipo);
    }

    @Test
    void setTipo() {
        apuesta.setTipo(mock(TipoApuesta.class));
    }

    @Test
    void cancelar() {
        try {
            apuesta.cancelar();
            verify(tipo).cancelar(evento, apuesta);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void reactivar() {
        try {
            apuesta.reactivar();
            verify(tipo).reactivar(evento, apuesta);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void gananciaBruta() {
        when(evento.terminado()).thenReturn(true);
        try {
            when(tipo.ganancia(evento, "L", BigDecimal.TEN)).thenReturn(BigDecimal.ONE);
            assertEquals(0, apuesta.gananciaBruta().compareTo(new BigDecimal(11)));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void gananciaNeta() {
        when(evento.terminado()).thenReturn(true);
        try {
            when(tipo.ganancia(evento, "L", BigDecimal.TEN)).thenReturn(BigDecimal.ONE);
            assertEquals(0, apuesta.gananciaNeta().compareTo(BigDecimal.ONE));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void gananciaNetaTerminado() {
        when(evento.terminado()).thenReturn(false);
        try {
            apuesta.gananciaNeta();
            fail();
        } catch(Exception e) {
            //e.printStackTrace();
        }
    }

    @Test
    void inMonth() {
        when(evento.inMonth(1)).thenReturn(true);
        assertTrue(apuesta.inMonth(1));
    }
}