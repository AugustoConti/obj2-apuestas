package casa.partido.estados;

import casa.ITipeable;
import casa.apuestas.tipos.SeguraActiva;
import casa.apuestas.tipos.SeguraCanceladaNoEmpezado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class NoEmpezadoTest {

    private EstadoPartido noEmpezado;

    @BeforeEach
    void setUp() {
        noEmpezado = new NoEmpezado();
    }

    @Test
    void terminado() {
        assertFalse(noEmpezado.terminado());
    }

    @Test
    void cancelarApuesta() {
        try {
            ITipeable apuesta = mock(ITipeable.class);
            noEmpezado.cancelarApuesta(apuesta);
            verify(apuesta).setTipo(any(SeguraCanceladaNoEmpezado.class));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void reactivarApuesta() {
        try {
            ITipeable apuesta = mock(ITipeable.class);
            noEmpezado.reactivarApuesta(apuesta);
            verify(apuesta).setTipo(any(SeguraActiva.class));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}