package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.apuestas.tipos.cancelada.CanceladaInterface;
import casa.partido.Ganador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SeguraCanceladaTest {

    private SeguraCancelada cancelada;

    @BeforeEach
    void setUp() {
        CanceladaInterface tipo = mock(CanceladaInterface.class);
        when(tipo.ganancia(any(Evento.class), any(Ganador.class), any(BigDecimal.class))).thenReturn(BigDecimal.ONE);
        cancelada = new SeguraCancelada(tipo);
    }

    @Test
    void cancelar() {
        assertThrows(Exception.class, () -> cancelada.cancelar(mock(Evento.class), mock(TipeableInterface.class)));
    }

    @Test
    void reactivar() throws Exception {
        Evento evento = mock(Evento.class);
        TipeableInterface apuesta = mock(TipeableInterface.class);
        cancelada.reactivar(evento, apuesta);
        verify(evento).reactivarApuesta(apuesta);
    }

    @Test
    void ganancia() {
        assertEquals(0, cancelada.ganancia(mock(Evento.class), Ganador.VISITANTE, BigDecimal.TEN).compareTo(BigDecimal.ONE));
    }
}