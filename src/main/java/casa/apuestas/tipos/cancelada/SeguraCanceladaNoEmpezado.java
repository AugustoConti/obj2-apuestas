package casa.apuestas.tipos.cancelada;

import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;

public class SeguraCanceladaNoEmpezado implements CanceladaInterface {
    /**
     * Se le cobra al usuario una penalidad fija de $200
     */
    @Override
    public BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto) {
        return new BigDecimal(-200);
    }
}
