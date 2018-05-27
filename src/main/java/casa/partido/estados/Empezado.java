package casa.partido.estados;

import casa.IEstado;
import casa.apuestas.tipos.estados.CanceladaEmpezado;

public class Empezado implements EstadoPartido {
    @Override
    public boolean terminado() {
        return false;
    }

    @Override
    public void cancelarApuesta(IEstado apuesta) {
        apuesta.setEstado(new CanceladaEmpezado());
    }

    @Override
    public void reactivarApuesta(IEstado apuesta) throws Exception {
        throw new Exception("No se puede reactivar apuesta con el partido empezado");
    }
}
