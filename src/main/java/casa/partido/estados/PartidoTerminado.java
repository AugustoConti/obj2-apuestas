package casa.partido.estados;

import casa.TipeableInterface;
import casa.partido.PartidoInterface;

public class PartidoTerminado implements EstadoPartido {
    @Override
    public boolean terminado() {
        return true;
    }

    @Override
    public void nextState(PartidoInterface partido) {}

    @Override
    public void cancelarApuesta(TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede cancelar apuesta con el partido terminado");
    }

    @Override
    public void reactivarApuesta(TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede reactivar apuesta con el partido terminado");
    }
}
