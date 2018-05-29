package casa.apuestas;

import casa.TipeableInterface;
import casa.cuotas.AlgortimoInterface;
import casa.partido.PartidoInterface;
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
    private PartidoInterface partido;

    @BeforeEach
    void setUp() {
        partido = mock(PartidoInterface.class);

        AlgortimoInterface algoritmo = mock(AlgortimoInterface.class);
        when(algoritmo.local(any(PartidoInterface.class))).thenReturn(BigDecimal.ZERO);
        when(algoritmo.empate(any(PartidoInterface.class))).thenReturn(BigDecimal.ONE);
        when(algoritmo.visitante(any(PartidoInterface.class))).thenReturn(BigDecimal.TEN);

        evento = new Evento(partido, algoritmo);
    }

    @Test
    void inMonth() {
        evento.inMonth(1);
        verify(partido).inMonth(1);
    }

    @Test
    void cancelarApuesta() throws Exception{
            evento.cancelarApuesta(mock(TipeableInterface.class));
            verify(partido).cancelarApuesta(any(TipeableInterface.class));

    }

    @Test
    void reactivarApuesta() throws Exception{

            evento.reactivarApuesta(mock(TipeableInterface.class));
            verify(partido).reactivarApuesta(any(TipeableInterface.class));
    }

    @Test
    void terminado() {
        when(partido.terminado()).thenReturn(true);
        assertTrue(evento.terminado());
    }

    @Test
    void acierto() throws Exception {
            when(partido.acierto("L")).thenReturn(true);
            assertTrue(evento.acierto("L"));
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