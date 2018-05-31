package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.awt.geom.RoundRectangle2D;
import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.Float.valueOf;

public class SeguraActiva implements TipoApuestaInterface {

    /* Porcentaje a descontar, en porcentaje (15%) */
    private static Float porcentajeADescontar = Float.valueOf(15);


    /* Cancela la apuesta en un evento, recibe un evento y una apuesta*/
    @Override
    public void cancelar(Evento evento, TipeableInterface apuesta) throws Exception {
        evento.cancelarApuesta(apuesta);
    }

    /* sobreescribe el metodo reactivar lanzando una exepcion, una apuesta activa no puede se reactivada */
    @Override
    public void reactivar(Evento evento, TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede reactivar una apuesta activa");
    }


    /* Sobreescribe el metodo ganancia neta. En caso de acierto de le descuenta el 15% de la ganancia y retorna en neto de la ganancia  */
    @Override
    public BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto) {

        BigDecimal ret;
        if(evento.acierto(favorito))
            ret = evento.cuota(favorito).multiply(BigDecimal.valueOf( 1 - porcentajeADescontar / 100));
        else
            ret = new BigDecimal(-1);
        return ret.multiply(monto, new MathContext(2));
    }


}
