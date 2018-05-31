package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;

public class SeguraCanceladaNoEmpezado implements TipoApuestaInterface {

    /* se le cobra al usuario una penalidad fija de $200 */
    private static BigDecimal penalidadPorCancelar =  new BigDecimal(-200);

    /* Sobreescribe el metodo cancelar. Una apuesta cancelada no pude ser cancelada*/
    @Override
    public void cancelar(Evento evento, TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede cancelar una apuesta cancelada");
    }

    /*Sobreescribe el metodo reactivar. Recibe un evento y una apuesta y la reactiva, si no es posible lanza una excepcion*/
    @Override
    public void reactivar(Evento evento, TipeableInterface apuesta) throws Exception {
        evento.reactivarApuesta(apuesta);
    }

    /*Sobreescribe el metodo gancia. Se le cobra al usuario una penalidad fija de $200*/
    @Override
    public BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto) {
        return penalidadPorCancelar;
    }
}
