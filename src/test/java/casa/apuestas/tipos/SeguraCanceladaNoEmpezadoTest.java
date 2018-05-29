package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SeguraCanceladaNoEmpezadoTest {

    private TipoApuestaInterface canceladaNoEmpezado;

    @BeforeEach
    void setUp() {
        canceladaNoEmpezado = new SeguraCanceladaNoEmpezado();
    }

    @Test
    void cancelar() {
        try {
            canceladaNoEmpezado.cancelar(mock(Evento.class), mock(TipeableInterface.class));
            fail();
        } catch(Exception e) {
            //e.printStackTrace();
        }
    }

    @Test
    void reactivar() {
        Evento evento = mock(Evento.class);
        TipeableInterface apuesta = mock(TipeableInterface.class);
        try {
            canceladaNoEmpezado.reactivar(evento, apuesta);
            verify(evento).reactivarApuesta(apuesta);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void ganancia() {
        try {
            assertEquals(0, canceladaNoEmpezado.ganancia(mock(Evento.class), "L", BigDecimal.TEN).compareTo(new BigDecimal(-200)));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}