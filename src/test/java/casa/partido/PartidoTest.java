package casa.partido;

import casa.TipeableInterface;
import casa.partido.deportes.DeporteInterface;
import casa.partido.estados.EstadoPartido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PartidoTest {

    private PartidoInterface partido;
    private OponenteInterface local;
    private OponenteInterface visitante;
    private EstadoPartido estado;
    private DeporteInterface deporte;

    @BeforeEach
    void setUp() {
        local = mock(OponenteInterface.class);
        visitante = mock(OponenteInterface.class);
        estado = mock(EstadoPartido.class);
        deporte = mock(DeporteInterface.class);
        when(estado.terminado()).thenReturn(true);
        partido = new Partido(deporte, local, visitante,
                LocalDateTime.of(2018, 5, 25, 10, 0), "Bernal",
                Ganador.NINGUNO, estado);
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
        assertTrue(partido.terminado());
    }

    @Test
    void aciertoTrue() throws Exception {
        when(deporte.admiteEmpate()).thenReturn(true);
        assertTrue(partido.acierto(Ganador.NINGUNO));
    }

    @Test
    void aciertoFalse() throws Exception {
        when(deporte.admiteEmpate()).thenReturn(true);
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
    void nextState(){
        partido.nextState();
        verify(estado).nextState(partido);
    }
}