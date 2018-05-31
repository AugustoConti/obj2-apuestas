package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;

public class Final implements TipoApuestaInterface {

    @Override
    public void cancelar(Evento evento, TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede cancelar una apuesta final");
    }

    @Override
    public void reactivar(Evento evento, TipeableInterface apuesta) throws Exception {
            throw new Exception("No se puede reactivar una apuesta final");
    }

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
