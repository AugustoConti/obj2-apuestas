package casa.partido;

import casa.TipeableInterface;
import casa.partido.deportes.DeporteInterface;
import casa.partido.estados.EstadoPartido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PartidoTest {

    private Partido partido;
    private OponenteInterface local;
    private OponenteInterface visitante;
    private EstadoPartido estado;
    private LocalDateTime fecha;

    @BeforeEach
    void setUp() {
        local = mock(OponenteInterface.class);
        visitante = mock(OponenteInterface.class);
        fecha = LocalDateTime.of(2018, 5, 25, 10, 0);
        estado = mock(EstadoPartido.class);
        when(estado.terminado()).thenReturn(true);
        partido = new Partido(mock(DeporteInterface.class), local, visitante, fecha, "Bernal", Ganador.NINGUNO, estado);
    }

    @Test
    void local() {
        assertEquals(local, partido.local());
    }

    @Test
    void visitante() {
        assertEquals(visitante, partido.visitante());
    }

    @Test
    void ganador() {
        assertEquals(Ganador.NINGUNO, partido.ganador());
    }

    @Test
    void terminado() {
        assertTrue(partido.terminado());
    }

    @Test
    void aciertoTrue() {
        assertTrue(partido.acierto(Ganador.NINGUNO));
    }

    @Test
    void aciertoFalse() {
        assertFalse(partido.acierto(Ganador.VISITANTE));
    }

    @Test
    void inMonthTrue() {
        assertTrue(partido.inMonth(Month.MAY));
    }

    @Test
    void inMonthFalse() {
        assertFalse(partido.inMonth(Month.JANUARY));
    }

    @Test
    void fecha() {
        assertEquals(fecha, partido.fecha());
    }

    @Test
    void cancelarApuesta() throws Exception {
        TipeableInterface apuesta = mock(TipeableInterface.class);
        partido.cancelarApuesta(apuesta);
        verify(estado).cancelarApuesta(apuesta);
    }

    @Test
    void reactivarApuesta() throws Exception {
        TipeableInterface apuesta = mock(TipeableInterface.class);
        partido.reactivarApuesta(apuesta);
        verify(estado).reactivarApuesta(apuesta);
    }

    @Test
    void nextState() {
        partido.nextState();
        verify(estado).nextState(partido);
    }

    @Test
    void nextStateTerminado() {
        EstadoPartido estadoTerminado = mock(EstadoPartido.class);
        partido.setState(estadoTerminado);
        partido.nextState();
        verify(estadoTerminado).nextState(partido);
    }
}