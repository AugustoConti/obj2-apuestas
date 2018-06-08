package casa.apuestas.tipos;

import casa.TipeableInterface;
import casa.apuestas.Evento;
import casa.apuestas.tipos.segura.SeguraInterface;
import casa.partido.Ganador;

import java.math.BigDecimal;

public class Segura implements TipoApuestaInterface, TipeableInterface {

    private SeguraInterface tipo;

    public Segura(SeguraInterface tipoSegura) {
        this.tipo = tipoSegura;
    }

    /**
     * Una apuesta segura no pude ser segura
     */
    @Override
    public void cancelar(Evento evento) throws Exception {
        tipo.cancelar(evento, this);
    }

    /**
     * Recibe un evento y una apuesta y la reactiva, si no es posible lanza una excepcion
     */
    @Override
    public void reactivar(Evento evento) throws Exception {
        tipo.reactivar(evento, this);
    }

    /**
     * Delega la ganancia en su tipo.
     */
    @Override
    public BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto) {
        return tipo.ganancia(evento, favorito, monto);
    }

    @Override
    public void setTipo(SeguraInterface tipo) {
        this.tipo = tipo;
    }
}
