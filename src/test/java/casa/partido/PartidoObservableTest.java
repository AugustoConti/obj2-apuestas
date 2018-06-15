package casa.partido;

import casa.CasaDeApuestas;
import casa.partido.deportes.DeporteInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

class PartidoObservableTest {

    private Partido partido;

    @BeforeEach
    void setUp() {
        partido = new Partido(mock(DeporteInterface.class),
        mock(OponenteInterface.class), mock(OponenteInterface.class),
        mock(LocalDateTime.class), mock(String.class), Ganador.NINGUNO);
        //TODO Testear observer.
        CasaDeApuestas o = mock(CasaDeApuestas.class);
        partido.addObserver(o);
    }

    @Test
    void local() {
        fail();
    }
}
