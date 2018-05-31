package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;
import java.math.MathContext;

public class SeguraCanceladaEmpezado implements TipoApuestaInterface {

    /* Penalidad a descontar, en porcentaje (30%) */
    private static Float porcentajeADescontar = Float.valueOf(30);



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


    /* Sobreescribe el metodo ganancia. Se le cobra al usuario una penalidad del 30% del total que haya apostado. */
    @Override
    public BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto) {
        return monto.multiply( BigDecimal.valueOf( porcentajeADescontar / 100), new MathContext(2));
    }

}
