package casa.apuestas.tipos.estados;

import casa.IEstado;
import casa.apuestas.Evento;

import java.math.BigDecimal;

public interface EstadoApuesta {
    void cancelar(Evento evento, IEstado apuesta) throws Exception;
    void reactivar(Evento evento, IEstado apuesta) throws Exception;
    BigDecimal ganancia(Evento evento, String favorito, BigDecimal monto);
}
