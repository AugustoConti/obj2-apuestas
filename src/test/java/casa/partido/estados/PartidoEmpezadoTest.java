package casa.partido.estados;

import casa.TipeableInterface;
import casa.apuestas.tipos.SeguraCancelada;
import casa.partido.PartidoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PartidoEmpezadoTest {

    private PartidoEmpezado empezado;

    @BeforeEach
    void setUp() {
        empezado = new PartidoEmpezado();
    }

    @Test
    void terminado() {
        assertFalse(empezado.terminado());
    }

    @Test
    void cancelarApuesta() {
        TipeableInterface apuesta = mock(TipeableInterface.class);
        empezado.cancelarApuesta(apuesta);
        verify(apuesta).setTipo(any(SeguraCancelada.class));
    }

    @Test
    void reactivarApuesta() {
        assertThrows(Exception.class, () -> empezado.reactivarApuesta(mock(TipeableInterface.class)));
    }

    @Test
    void nextState() {
        PartidoInterface partido = mock(PartidoInterface.class);
        empezado.nextState(partido);
        verify(partido).setState(any(PartidoTerminado.class));
    }
}