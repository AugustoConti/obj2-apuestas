package casa.partido.estados;

import casa.TipeableInterface;
import casa.apuestas.tipos.segura.SeguraActiva;
import casa.apuestas.tipos.Segura;
import casa.apuestas.tipos.segura.SeguraCancelada;
import casa.apuestas.tipos.segura.cancelada.SeguraCanceladaNoEmpezado;
import casa.partido.Partido;

public class PartidoNoEmpezado implements EstadoPartido {

    /**
     * Retorna siempre false ya que el partido no termino
     */
    @Override
    public Boolean terminado() {
        return false;
    }

    /**
     * Recine un partido y cambia el estao del partido al siguiente estad, PartidoEmpezado
     */
    @Override
    public void nextState(Partido partido) {
        partido.setState(new PartidoEmpezado());
    }

    /**
     * Recibe una apuesta Segura y cancela la misma. Cambia el estado de la apuesta a SeguraCanceladaNoEmpezada
     */
    @Override
    public void cancelarApuesta(TipeableInterface apuesta) {
        apuesta.setTipo(new SeguraCancelada(new SeguraCanceladaNoEmpezado()));
    }

    /**
     * Recibe una apuesta. Cambia el estado de la misma a SeguraActiva
     */
    @Override
    public void reactivarApuesta(TipeableInterface apuesta) {
        apuesta.setTipo(new SeguraActiva());
    }
}
