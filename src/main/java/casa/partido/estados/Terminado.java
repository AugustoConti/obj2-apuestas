package casa.partido.estados;

import casa.ITipeable;

public class Terminado implements EstadoPartido {
    @Override
    public boolean terminado() {
        return true;
    }

    @Override
    public void cancelarApuesta(ITipeable apuesta) throws Exception {
        throw new Exception("No se puede cancelar apuesta con el partido terminado");
    }

    @Override
    public void reactivarApuesta(ITipeable apuesta) throws Exception {
        throw new Exception("No se puede reactivar apuesta con el partido terminado");
    }
}
