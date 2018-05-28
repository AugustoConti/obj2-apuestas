package casa.partido.estados;

import casa.ITipeable;
import casa.apuestas.tipos.SeguraCanceladaEmpezado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class EmpezadoTest {

    private EstadoPartido empezado;

    @BeforeEach
    void setUp() {
        empezado = new Empezado();
    }

    @Test
    void terminado() {
        assertFalse(empezado.terminado());
    }

    @Test
    void cancelarApuesta() {
        try {
            ITipeable apuesta = mock(ITipeable.class);
            empezado.cancelarApuesta(apuesta);
            verify(apuesta).setTipo(any(SeguraCanceladaEmpezado.class));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void reactivarApuesta() {
        try {
            empezado.reactivarApuesta(mock(ITipeable.class));
            fail();
        } catch(Exception e) {
            //e.printStackTrace();
        }
    }
}