package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SeguraCanceladaEmpezadoTest {

    private TipoApuestaInterface canceladaEmpezado;

    @BeforeEach
    void setUp() {
        canceladaEmpezado = new SeguraCanceladaEmpezado();
    }

    @Test
    void cancelar() {
        assertThrows(Exception.class, () -> canceladaEmpezado.cancelar(mock(Evento.class), mock(TipeableInterface.class)));
    }

    @Test
    void reactivar() throws Exception {
        Evento evento = mock(Evento.class);
        TipeableInterface apuesta = mock(TipeableInterface.class);

        canceladaEmpezado.reactivar(evento, apuesta);
        verify(evento).reactivarApuesta(apuesta);

    }

    @Test
    void ganancia() throws Exception {
        assertEquals(0, canceladaEmpezado.ganancia(mock(Evento.class), Ganador.VISITANTE, BigDecimal.TEN).compareTo(new BigDecimal(3)));
    }
}