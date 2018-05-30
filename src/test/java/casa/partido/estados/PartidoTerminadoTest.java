package casa.partido.estados;

import casa.TipeableInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PartidoTerminadoTest {

    private EstadoPartido terminado;

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
}