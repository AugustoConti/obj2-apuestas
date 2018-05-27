package casa.apuestas.tipos.estados;

import casa.IEstado;
import casa.apuestas.Evento;

import java.math.BigDecimal;

public class Activa implements EstadoApuesta {
    @Override
    public void cancelar(Evento evento, IEstado apuesta) throws Exception {
        evento.cancelarApuesta(apuesta);
    }

    @Override
    public void reactivar(Evento evento, IEstado apuesta) throws Exception {
        throw new Exception("No se puede reactivar una apuesta activa");
    }

    @Override
    public BigDecimal ganancia(Evento evento, String favorito, BigDecimal monto) {
        BigDecimal ret;
        if(evento.acierto(favorito))
            ret = evento.cuota(favorito).multiply(new BigDecimal(0.85));
        else
            ret = new BigDecimal(-1);
        return ret.multiply(monto);
    }
}
