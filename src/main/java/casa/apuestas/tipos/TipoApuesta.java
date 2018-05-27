package casa.apuestas.tipos;

import casa.apuestas.Evento;

import java.math.BigDecimal;

public interface TipoApuesta {
    void cancelar(Evento evento) throws Exception;
    void reactivar(Evento evento) throws Exception;
    BigDecimal ganancia(Evento evento, String favorito, BigDecimal monto);
}
