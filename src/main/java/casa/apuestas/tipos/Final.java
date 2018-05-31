package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;

public class Final implements TipoApuestaInterface {

    /* Sobreescribe el metodo cancelar. La apuesta final es una apuesta que no puede cancelarse en ningún momento.

     */
    @Override
    public void cancelar(Evento evento, TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede cancelar una apuesta final");
    }

    /* Sobreescribe el metodo reactivar. La apuesta final es una apuesta que no puede cancelarse en ningún momento.
    Por conseceucia no se puede ractivar
     */
    @Override
    public void reactivar(Evento evento, TipeableInterface apuesta) throws Exception {
            throw new Exception("No se puede reactivar una apuesta final");
    }

    /* Sobreescribe el metodo ganancia, Rertorna la ganancia dependiendo de la cuota y el resultado  */
    @Override
    public BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto) {
        BigDecimal ret;
        if(evento.acierto(favorito))
            ret = evento.cuota(favorito);
        else
            ret = new BigDecimal(-1);
        return ret.multiply(monto);
    }
}
