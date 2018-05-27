package casa.partido.estados;

import casa.IEstado;
import casa.apuestas.tipos.estados.Activa;
import casa.apuestas.tipos.estados.CanceladaNoEmpezado;

public class NoEmpezado implements EstadoPartido {
    @Override
    public boolean terminado() {
        return false;
    }

    @Override
    public void cancelarApuesta(IEstado apuesta) {
        apuesta.setEstado(new CanceladaNoEmpezado());
    }

    @Override
    public void reactivarApuesta(IEstado apuesta) {
        apuesta.setEstado(new Activa());
    }
}
