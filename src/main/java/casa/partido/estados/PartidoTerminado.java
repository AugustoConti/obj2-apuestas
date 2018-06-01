package casa.partido.estados;

import casa.TipeableInterface;
import casa.partido.PartidoInterface;

public class PartidoTerminado implements EstadoPartido {

    /**
     * Retorna true ya que el partido termino
     */
    @Override
    public Boolean terminado() {
        return true;
    }

    /**
     * No hace nada ya que no existe otro estado despues de Terminado
     */
    @Override
    public void nextState(PartidoInterface partido) {}

    /**
     * Recibe una Apuesta. Lanza una exepcion ya que no se puede cancelar una apuesta una vez terminado el partido
     */
    @Override
    public void cancelarApuesta(TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede cancelar apuesta con el partido terminado");
    }

    /**
     * Recine una apuesta. Lanza una exepcion ya que no se puede reactivar una apuesta de un partido terminado
     */
    @Override
    public void reactivarApuesta(TipeableInterface apuesta) throws Exception {
        throw new Exception("No se puede reactivar apuesta con el partido terminado");
    }
}
