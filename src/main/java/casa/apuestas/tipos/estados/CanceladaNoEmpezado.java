package casa.apuestas.tipos.estados;

import casa.IEstado;
import casa.apuestas.Evento;

import java.math.BigDecimal;

public class CanceladaNoEmpezado implements EstadoApuesta {
    @Override
    public void cancelar(Evento evento, IEstado apuesta) throws Exception {
        throw new Exception("No se puede cancelar una apuesta cancelada");
    }

    @Override
    public void reactivar(Evento evento, IEstado apuesta) throws Exception {
        evento.reactivarApuesta(apuesta);
    }

    @Override
    public BigDecimal ganancia(Evento evento, String favorito, BigDecimal monto) {
        return new BigDecimal(-200);
    }
}
