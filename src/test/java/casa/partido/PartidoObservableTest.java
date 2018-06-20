package casa.partido;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Observer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PartidoObservableTest {

    private Partido partido;
    private Observer o;

    @BeforeEach
    void setUp() {
        partido = new Partido(mock(Deporte.class),
                mock(OponenteInterface.class), mock(OponenteInterface.class),
                LocalDateTime.now(), "bernal", Ganador.NINGUNO);
        o = mock(Observer.class);
        partido.addObserver(o);
    }

    @Test
    void observadorNotificado() {
        partido.nextState();
        verify(o).update(partido, null);
    }
}
