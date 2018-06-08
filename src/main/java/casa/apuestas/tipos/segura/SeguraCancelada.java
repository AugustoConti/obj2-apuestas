package casa.apuestas.tipos.segura;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.apuestas.tipos.segura.cancelada.SeguraCanceladaInterface;
import casa.partido.Ganador;

import java.math.BigDecimal;

public class SeguraCancelada implements SeguraInterface {

    private SeguraCanceladaInterface estado;

    public SeguraCancelada(SeguraCanceladaInterface estado) {
        this.estado = estado;
    }

    @Override
    public void cancelar(Evento evento, TipeableInterface segura) throws Exception {
        throw new Exception("No se puede cancelar una apuesta segura");
    }

    @Override
    public void reactivar(Evento evento, TipeableInterface segura) throws Exception {
        evento.reactivarApuesta(segura);
    }

    @Override
    public BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto) {
        return estado.ganancia(monto);
    }
}
