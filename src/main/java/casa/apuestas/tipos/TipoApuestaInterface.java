package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;

public interface TipoApuestaInterface {

    /*Cancela una apuesta, recibe un evento y una apuesta */
    void cancelar(Evento evento, TipeableInterface apuesta) throws Exception;

    /* reactiva una apuestam recibe un evento y una apuesta*/
    void reactivar(Evento evento, TipeableInterface apuesta) throws Exception;
    BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto);
}
