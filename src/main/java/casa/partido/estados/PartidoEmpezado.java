package casa.partido.estados;

import casa.TipeableInterface;
import casa.apuestas.tipos.SeguraCanceladaEmpezado;
import casa.partido.PartidoInterface;

public class PartidoEmpezado implements EstadoPartido {

    /* Retorna siempre false si el partido no termino*/
    @Override
    public boolean terminado() {
        return false;
    }

    /* recibe un partido y Cambia al estado Terminado*/
    @Override
    public void nextState(PartidoInterface partido) {
        partido.setState(new PartidoTerminado());
    }

    /* recibe una apuesta. Cambia el estado de la apuesta a CanceladaEmpezado */
    @Override
    public void cancelarApuesta(TipeableInterface apuesta) {
        apuesta.setTipo(new SeguraCanceladaEmpezado());
    }

    /* Recibe una apuesta. Lanza una excepcio ya que un partido empezado no puede reactivar la apueza */
    @Override
    public void reactivarApuesta(TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede reactivar apuesta con el partido empezado");
    }
}
