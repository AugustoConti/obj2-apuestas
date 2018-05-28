package casa.apuestas.tipos;

import casa.ITipeable;
import casa.apuestas.Evento;

import java.math.BigDecimal;
import java.math.MathContext;

public class SeguraActiva implements TipoApuesta {
    @Override
    public void cancelar(Evento evento, ITipeable apuesta) throws Exception {
        evento.cancelarApuesta(apuesta);
    }

    @Override
    public void reactivar(Evento evento, ITipeable apuesta) throws Exception {
        throw new Exception("No se puede reactivar una apuesta activa");
    }

    @Override
    public BigDecimal ganancia(Evento evento, String favorito, BigDecimal monto) throws Exception {
        BigDecimal ret;
        if(evento.acierto(favorito))
            ret = evento.cuota(favorito).multiply(new BigDecimal(0.85));
        else
            ret = new BigDecimal(-1);
        return ret.multiply(monto, new MathContext(2));
    }
}
