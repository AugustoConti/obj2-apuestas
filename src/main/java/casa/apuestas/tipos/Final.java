package casa.apuestas.tipos;

import casa.ITipeable;
import casa.apuestas.Evento;

import java.math.BigDecimal;

public class Final implements TipoApuesta {

    @Override
    public void cancelar(Evento evento, ITipeable apuesta) throws Exception {
        throw new Exception("No se puede cancelar una apuesta final");
    }

    @Override
    public void reactivar(Evento evento, ITipeable apuesta) throws Exception {
            throw new Exception("No se puede reactivar una apuesta final");
    }

    @Override
    public BigDecimal ganancia(Evento evento, String favorito, BigDecimal monto) throws Exception {
        BigDecimal ret;
        if(evento.acierto(favorito))
            ret = evento.cuota(favorito);
        else
            ret = new BigDecimal(-1);
        return ret.multiply(monto);
    }
}
