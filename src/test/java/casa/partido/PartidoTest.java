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
    private LocalDateTime fecha;

    @BeforeEach
    void setUp() {
        local = mock(OponenteInterface.class);
        visitante = mock(OponenteInterface.class);
        fecha = LocalDateTime.of(2018, 5, 25, 10, 0);
        partido = new Partido(mock(DeporteInterface.class), local, visitante, fecha, "Bernal", Ganador.NINGUNO);
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
    void terminado() {
        partido.nextState();
        partido.nextState();
        assertTrue(partido.terminado());
    }

    @Test
    void noTerminado() {
        assertFalse(partido.terminado());
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
        EstadoPartido estado = mock(EstadoPartido.class);
        TipeableInterface apuesta = mock(TipeableInterface.class);
        partido.setState(estado);
        partido.cancelarApuesta(apuesta);
        verify(estado).cancelarApuesta(apuesta);
    }

    @Test
    void reactivarApuesta() throws Exception {
        EstadoPartido estado = mock(EstadoPartido.class);
        TipeableInterface apuesta = mock(TipeableInterface.class);
        partido.setState(estado);
        partido.reactivarApuesta(apuesta);
        verify(estado).reactivarApuesta(apuesta);
    }
}