package casa.partido.estados;

import casa.TipeableInterface;
import casa.apuestas.tipos.SeguraActiva;
import casa.apuestas.tipos.SeguraCanceladaNoEmpezado;
import casa.partido.PartidoInterface;

public class PartidoNoEmpezado implements EstadoPartido {

    /* Retorna siempre false ya que el partido no termino  */
    @Override
    public boolean terminado() {
        return false;
    }

    /* Recine un partido y cambia el estao del partido al siguiente estad, PartidoEmpezado */
    @Override
    public void nextState(PartidoInterface partido) {
        partido.setState(new PartidoEmpezado());
    }

    /* Recibe una apuesta Segura y cancela la misma. Cambia el estado de la apuesta a SeguraCanceladaNoEmpezada */
    @Override
    public void cancelarApuesta(TipeableInterface apuesta) {
        apuesta.setTipo(new SeguraCanceladaNoEmpezado());
    }

    /*Recibe una apuesta. Cambia el estado de la misma a SeguraActiva */
    @Override
    public void reactivarApuesta(TipeableInterface apuesta) {
        apuesta.setTipo(new SeguraActiva());
    }
}
