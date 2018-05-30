package casa.partido.estados;

import casa.TipeableInterface;
import casa.apuestas.tipos.SeguraActiva;
import casa.apuestas.tipos.SeguraCanceladaNoEmpezado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PartidoNoEmpezadoTest {

    private EstadoPartido noEmpezado;

    @BeforeEach
    void setUp() {
        noEmpezado = new PartidoNoEmpezado();
    }

    @Test
    void terminado() {
        assertFalse(noEmpezado.terminado());
    }

    @Test
    void cancelarApuesta() throws Exception {
        TipeableInterface apuesta = mock(TipeableInterface.class);
        noEmpezado.cancelarApuesta(apuesta);
        verify(apuesta).setTipo(any(SeguraCanceladaNoEmpezado.class));
    }

    @Test
    void reactivarApuesta() throws Exception {

        TipeableInterface apuesta = mock(TipeableInterface.class);
        noEmpezado.reactivarApuesta(apuesta);
        verify(apuesta).setTipo(any(SeguraActiva.class));

    }
}