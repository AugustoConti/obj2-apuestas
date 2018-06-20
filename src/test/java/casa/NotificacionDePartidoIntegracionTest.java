package casa;

import casa.apuestas.Apuesta;
import casa.apuestas.Evento;
import casa.apuestas.tipos.TipoApuestaInterface;
import casa.cuotas.CuotaInterface;
import casa.partido.Deporte;
import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.Partido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.*;


class NotificacionDePartidoIntegracionTest {

    private User userSpy;
    private CasaDeApuestas casaSpy;
    private Partido partido;

    @BeforeEach
    void setUp() {
        userSpy = spy(new User("Juan", "juan@gmail.com", new ArrayList<>()));
        casaSpy = spy(new CasaDeApuestas(new ArrayList<>(Collections.singletonList(userSpy)), new Historial(new
                ArrayList<>())));
        partido = new Partido(mock(Deporte.class), mock(OponenteInterface.class), mock(OponenteInterface.class),
                LocalDateTime.now(), "Bernal", Ganador.NINGUNO);
        casaSpy.addPartido(partido);
        userSpy.addApuesta(new Apuesta(BigDecimal.TEN, Ganador.VISITANTE, new Evento(partido, mock(CuotaInterface.class)),
                mock(TipoApuestaInterface.class)));
    }

    @Test
    void notificacion() {
        partido.nextState();
        verify(userSpy).update(partido, null);
        verify(casaSpy).update(partido, null);
    }

}