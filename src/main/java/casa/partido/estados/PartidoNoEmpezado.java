package casa.partido.estados;

import casa.TipeableInterface;
import casa.apuestas.tipos.SeguraActiva;
import casa.apuestas.tipos.SeguraCanceladaNoEmpezado;
import casa.partido.PartidoInterface;

public class PartidoNoEmpezado implements EstadoPartido {
    @Override
    public boolean terminado() {
        return false;
    }

    @Override
    public void nextState(PartidoInterface partido) {
        partido.setState(new PartidoEmpezado());
    }

    @Override
    public void cancelarApuesta(TipeableInterface apuesta) {
        apuesta.setTipo(new SeguraCanceladaNoEmpezado());
    }

    @Override
    public void reactivarApuesta(TipeableInterface apuesta) {
        apuesta.setTipo(new SeguraActiva());
    }
}
