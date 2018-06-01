package casa.partido.estados;

import casa.TipeableInterface;
import casa.apuestas.tipos.SeguraActiva;
import casa.apuestas.tipos.SeguraCancelada;
import casa.partido.PartidoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PartidoNoEmpezadoTest {

    private PartidoNoEmpezado noEmpezado;

    @BeforeEach
    void setUp() {
        noEmpezado = new PartidoNoEmpezado();
    }

    @Test
    void terminado() {
        assertFalse(noEmpezado.terminado());
    }

    @Test
    void cancelarApuesta() {
        TipeableInterface apuesta = mock(TipeableInterface.class);
        noEmpezado.cancelarApuesta(apuesta);
        verify(apuesta).setTipo(any(SeguraCancelada.class));
    }

    @Test
    void reactivarApuesta() {

        TipeableInterface apuesta = mock(TipeableInterface.class);
        noEmpezado.reactivarApuesta(apuesta);
        verify(apuesta).setTipo(any(SeguraActiva.class));
    }

    @Test
    void nextState() {
        PartidoInterface partido = mock(PartidoInterface.class);
        noEmpezado.nextState(partido);
        verify(partido).setState(any(PartidoEmpezado.class));
    }
}