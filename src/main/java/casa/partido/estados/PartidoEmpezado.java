package casa.partido.estados;

import casa.TipeableInterface;
import casa.apuestas.tipos.SeguraCanceladaEmpezado;

public class PartidoEmpezado implements EstadoPartido {
    @Override
    public boolean terminado() {
        return false;
    }

    @Override
    public void cancelarApuesta(TipeableInterface apuesta) {
        apuesta.setTipo(new SeguraCanceladaEmpezado());
    }

    @Override
    public void reactivarApuesta(TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede reactivar apuesta con el partido empezado");
    }
}
