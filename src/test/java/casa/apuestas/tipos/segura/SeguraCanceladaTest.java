package casa.apuestas.tipos.segura;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.apuestas.tipos.segura.cancelada.SeguraCanceladaInterface;
import casa.partido.Ganador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class SeguraCanceladaTest {

    private SeguraCancelada seguraCancelada;

    @BeforeEach
    void setUp() {
        SeguraCanceladaInterface estado = mock(SeguraCanceladaInterface.class);
        when(estado.ganancia(any(BigDecimal.class))).thenReturn(BigDecimal.ONE);
        seguraCancelada = new SeguraCancelada(estado);
    }

    @Test
    void cancelar() {
        assertThrows(Exception.class, () -> seguraCancelada.cancelar(mock(Evento.class), mock(TipeableInterface.class)));
    }

    @Test
    void reactivar() throws Exception {
        Evento evento = mock(Evento.class);
        TipeableInterface apuesta = mock(TipeableInterface.class);
        seguraCancelada.reactivar(evento, apuesta);
        verify(evento).reactivarApuesta(apuesta);
    }

    @Test
    void ganancia() {
        assertEquals(0, seguraCancelada.ganancia(mock(Evento.class), Ganador.VISITANTE, BigDecimal.TEN).compareTo(BigDecimal.ONE));
    }
}