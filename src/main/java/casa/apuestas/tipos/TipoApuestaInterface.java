package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;

public interface TipoApuestaInterface {
    void cancelar(Evento evento, TipeableInterface apuesta) throws Exception;
    void reactivar(Evento evento, TipeableInterface apuesta) throws Exception;
    BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto);
}
