package casa.apuestas.tipos;

import casa.ITipeable;
import casa.apuestas.Evento;

import java.math.BigDecimal;

public interface TipoApuesta {
    void cancelar(Evento evento, ITipeable apuesta) throws Exception;
    void reactivar(Evento evento, ITipeable apuesta) throws Exception;
    BigDecimal ganancia(Evento evento, String favorito, BigDecimal monto) throws Exception;
}
