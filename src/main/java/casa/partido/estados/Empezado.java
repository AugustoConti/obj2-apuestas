package casa.partido.estados;

import casa.ITipeable;
import casa.apuestas.tipos.SeguraCanceladaEmpezado;

public class Empezado implements EstadoPartido {
    @Override
    public boolean terminado() {
        return false;
    }

    @Override
    public void cancelarApuesta(ITipeable apuesta) {
        apuesta.setTipo(new SeguraCanceladaEmpezado());
    }

    @Override
    public void reactivarApuesta(ITipeable apuesta) throws Exception {
        throw new Exception("No se puede reactivar apuesta con el partido empezado");
    }
}
