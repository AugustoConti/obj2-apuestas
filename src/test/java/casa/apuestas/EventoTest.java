package casa.apuestas;

import casa.ITipeable;
import casa.cuotas.IAlgoritmo;
import casa.partido.IPartido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EventoTest {

    private Evento evento;
    private IPartido partido;

    @BeforeEach
    void setUp() {
        partido = mock(IPartido.class);

        IAlgoritmo algoritmo = mock(IAlgoritmo.class);
        when(algoritmo.local(any(IPartido.class))).thenReturn(BigDecimal.ZERO);
        when(algoritmo.empate(any(IPartido.class))).thenReturn(BigDecimal.ONE);
        when(algoritmo.visitante(any(IPartido.class))).thenReturn(BigDecimal.TEN);

        evento = new Evento(partido, algoritmo);
    }

    @Test
    void inMonth() {
        evento.inMonth(1);
        verify(partido).inMonth(1);
    }

    @Test
    void cancelarApuesta() {
        try {
            evento.cancelarApuesta(mock(ITipeable.class));
            verify(partido).cancelarApuesta(any(ITipeable.class));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void reactivarApuesta() {
        try {
            evento.reactivarApuesta(mock(ITipeable.class));
            verify(partido).reactivarApuesta(any(ITipeable.class));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void terminado() {
        when(partido.terminado()).thenReturn(true);
        assertTrue(evento.terminado());
    }

    @Test
    void acierto() {
        try {
            when(partido.acierto("L")).thenReturn(true);
            assertTrue(evento.acierto("L"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void cuotaLocal() {
        assertEquals(0, evento.cuota("L").compareTo(BigDecimal.ZERO));
    }

    @Test
    void cuotaEmpate() {
        assertEquals(0, evento.cuota("E").compareTo(BigDecimal.ONE));
    }

    @Test
    void cuotaVisitante() {
        assertEquals(0, evento.cuota("V").compareTo(BigDecimal.TEN));
    }

    @Test
    void cuotaDefault() {
        assertEquals(0, evento.cuota("FRUTA").compareTo(BigDecimal.ZERO));
    }
}