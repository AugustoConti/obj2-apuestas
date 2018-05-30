package casa.partido.estados;

import casa.TipeableInterface;
import casa.apuestas.tipos.SeguraCanceladaEmpezado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PartidoEmpezadoTest {

    private EstadoPartido empezado;

    @BeforeEach
    void setUp() {
        empezado = new PartidoEmpezado();
    }

    @Test
    void terminado() {
        assertFalse(empezado.terminado());
    }

    @Test
    void cancelarApuesta() throws Exception {
        TipeableInterface apuesta = mock(TipeableInterface.class);
        empezado.cancelarApuesta(apuesta);
        verify(apuesta).setTipo(any(SeguraCanceladaEmpezado.class));
    }

    @Test
    void reactivarApuesta() {
        assertThrows(Exception.class, () -> empezado.reactivarApuesta(mock(TipeableInterface.class)));
    }
}