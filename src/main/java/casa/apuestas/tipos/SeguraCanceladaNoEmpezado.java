package casa.apuestas.tipos;

import casa.ITipeable;
import casa.apuestas.Evento;

import java.math.BigDecimal;

public class SeguraCanceladaNoEmpezado implements TipoApuesta {
    @Override
    public void cancelar(Evento evento, ITipeable apuesta) throws Exception {
        throw new Exception("No se puede cancelar una apuesta cancelada");
    }

    @Override
    public void reactivar(Evento evento, ITipeable apuesta) throws Exception {
        evento.reactivarApuesta(apuesta);
    }

    @Override
    public BigDecimal ganancia(Evento evento, String favorito, BigDecimal monto) {
        return new BigDecimal(-200);
    }
}
