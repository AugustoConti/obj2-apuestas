package casa.apuestas;

import casa.TipeableInterface;
import casa.apuestas.tipos.TipoApuestaInterface;
import casa.partido.Ganador;

import java.math.BigDecimal;
import java.time.Month;

public class Apuesta implements TipeableInterface {
    private BigDecimal monto;
    private Ganador favorito;
    private Evento evento;
    private TipoApuestaInterface tipo;

    /*Constructor. Crea una apuesta. Recibe un monto, un equipo, un evento y un tipo de apuesta */
    public Apuesta(BigDecimal monto, Ganador favorito, Evento evento, TipoApuestaInterface tipo) {
        this.monto = monto;
        this.favorito = favorito;
        this.evento = evento;
        this.tipo = tipo;
    }

    /*Setea el tipo de apuesta*/
    public void setTipo(TipoApuestaInterface tipo) {
        this.tipo = tipo;
    }

    /* Cancela la apuesta hecha */
    public void cancelar() throws Exception {
        tipo.cancelar(evento, this);
    }

    /* Reactiva la apuesta hacha */
    public void reactivar() throws Exception {
        tipo.reactivar(evento, this);
    }

    /* Retorna la ganancia Bruta ( ganancia neta + monto apostado ) */
    public BigDecimal gananciaBruta() {
        return gananciaNeta().add(monto);
    }

    /* Retorna la ganancia neta de la apuesta . retorna 0 si el evento no termino */
    public BigDecimal gananciaNeta() {
        if (!evento.terminado()) {
            return BigDecimal.ZERO;
        }
        return tipo.ganancia(evento, favorito, monto);
    }

    /* Retorna el mes del evento */
    public boolean inMonth(Month month) {
        return evento.inMonth(month);
    }
}
