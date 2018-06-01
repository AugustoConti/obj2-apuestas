package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.apuestas.tipos.cancelada.CanceladaInterface;
import casa.partido.Ganador;

import java.math.BigDecimal;

public class SeguraCancelada implements TipoApuestaInterface {

    private CanceladaInterface tipoCancelada;

    public SeguraCancelada(CanceladaInterface tipoCancelada) {this.tipoCancelada = tipoCancelada;}

    /**
     * Una apuesta cancelada no pude ser cancelada
     */
    @Override
    public void cancelar(Evento evento, TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede cancelar una apuesta cancelada");
    }

    /**
     * Recibe un evento y una apuesta y la reactiva, si no es posible lanza una excepcion
     */
    @Override
    public void reactivar(Evento evento, TipeableInterface apuesta) throws Exception {
        evento.reactivarApuesta(apuesta);
    }

    /**
     * Delega la ganancia en su tipo.
     */
    @Override
    public BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto) {
        return tipoCancelada.ganancia(evento, favorito, monto);
    }
}
