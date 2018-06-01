package casa.apuestas.tipos.cancelada;

import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;

public interface CanceladaInterface {

    BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto);

}
