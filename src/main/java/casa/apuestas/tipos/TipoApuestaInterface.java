package casa.apuestas.tipos;

import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;

public interface TipoApuestaInterface {

    void cancelar(Evento evento) throws Exception;

    void reactivar(Evento evento) throws Exception;

    BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto);

}
