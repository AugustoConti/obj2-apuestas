package casa.partido.estados;

import casa.TipeableInterface;
import casa.partido.PartidoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

class PartidoTerminadoTest {

    private PartidoTerminado terminado;

    @BeforeEach
    void setUp() {
        terminado = new PartidoTerminado();
    }

    @Test
    void terminado() {
        assertTrue(terminado.terminado());
    }

    @Test
    void cancelarApuesta() {
        assertThrows(Exception.class,
                () -> terminado.cancelarApuesta(mock(TipeableInterface.class)));
    }

    @Test
    void reactivarApuesta() {
        assertThrows(Exception.class,
                () -> terminado.reactivarApuesta(mock(TipeableInterface.class)));
    }

    @Test
    void nextState() {
        PartidoInterface partido = mock(PartidoInterface.class);
        terminado.nextState(partido);
        verifyZeroInteractions(partido);
    }
}