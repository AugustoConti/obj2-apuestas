package casa.apuestas.tipos.segura;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;

public interface SeguraInterface {

    void cancelar(Evento evento, TipeableInterface segura) throws Exception;

    void reactivar(Evento evento, TipeableInterface segura) throws Exception;

    BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto);

}
