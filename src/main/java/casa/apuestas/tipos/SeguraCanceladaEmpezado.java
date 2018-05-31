package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;
import java.math.MathContext;

public class SeguraCanceladaEmpezado implements TipoApuestaInterface {
    @Override
    public void cancelar(Evento evento, TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede cancelar una apuesta cancelada");
    }

    @Override
    public void reactivar(Evento evento, TipeableInterface apuesta) throws Exception {
        evento.reactivarApuesta(apuesta);
    }

    @Override
    public BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto) {
        return monto.multiply(new BigDecimal(0.3), new MathContext(2));
    }
}
