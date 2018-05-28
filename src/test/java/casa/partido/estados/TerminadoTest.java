package casa.partido.estados;

import casa.ITipeable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TerminadoTest {

    private EstadoPartido terminado;

    @BeforeEach
    void setUp() {
        terminado = new Terminado();
    }

    @Test
    void terminado() {
        assertTrue(terminado.terminado());
    }

    @Test
    void cancelarApuesta() {
        try {
            terminado.cancelarApuesta(mock(ITipeable.class));
            fail();
        } catch(Exception e) {
            //e.printStackTrace();
        }
    }

    @Test
    void reactivarApuesta() {
        try {
            terminado.reactivarApuesta(mock(ITipeable.class));
            fail();
        } catch(Exception e) {
            //e.printStackTrace();
        }
    }
}