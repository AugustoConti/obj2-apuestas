package casa.apuestas;

import casa.TipeableInterface;
import casa.cuotas.AlgortimoInterface;
import casa.partido.Ganador;
import casa.partido.PartidoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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
        evento.inMonth(Month.JANUARY);
        verify(partido).inMonth(Month.JANUARY);
    }

    @Test
    void cancelarApuesta() throws Exception {
        evento.cancelarApuesta(mock(TipeableInterface.class));
        verify(partido).cancelarApuesta(any(TipeableInterface.class));

    }

    @Test
    void reactivarApuesta() throws Exception {
        evento.reactivarApuesta(mock(TipeableInterface.class));
        verify(partido).reactivarApuesta(any(TipeableInterface.class));
    }

    @Test
    void terminado() {
        when(partido.terminado()).thenReturn(true);
        assertTrue(evento.terminado());
    }

    @Test
    void acierto() {
        when(partido.acierto(Ganador.VISITANTE)).thenReturn(true);
        assertTrue(evento.acierto(Ganador.VISITANTE));
    }

    @Test
    void cuotaLocal() {
        assertEquals(0, evento.cuota(Ganador.LOCAL).compareTo(BigDecimal.ZERO));
    }

    @Test
    void cuotaEmpate() {
        assertEquals(0, evento.cuota(Ganador.NINGUNO).compareTo(BigDecimal.ONE));
    }

    @Test
    void cuotaVisitante() {
        assertEquals(0, evento.cuota(Ganador.VISITANTE).compareTo(BigDecimal.TEN));
    }
}