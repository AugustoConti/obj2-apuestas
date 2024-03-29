package casa.apuestas;

import casa.apuestas.tipos.TipoApuestaInterface;
import casa.partido.Ganador;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Observer;

public class Apuesta {
    private final BigDecimal monto;
    private final Ganador favorito;
    private final Evento evento;
    private final TipoApuestaInterface tipo;

    /**
     * Constructor. Crea una apuesta. Recibe un monto, un equipo, un evento y un tipo de apuesta
     */
    public Apuesta(BigDecimal monto, Ganador favorito, Evento evento, TipoApuestaInterface tipo) {
        this.monto = monto;
        this.favorito = favorito;
        this.evento = evento;
        this.tipo = tipo;
    }

    /**
     * Cancela la apuesta hecha
     */
    public void cancelar() throws Exception {
        tipo.cancelar(evento);
    }

    /**
     * Reactiva la apuesta hacha
     */
    public void reactivar() throws Exception {
        tipo.reactivar(evento);
    }

    /**
     * Retorna la ganancia Bruta ( ganancia neta + monto apostado )
     */
    public BigDecimal gananciaBruta() {
        return gananciaNeta().add(monto);
    }

    /**
     * Retorna la ganancia neta de la apuesta . retorna 0 si el evento no termino
     */
    public BigDecimal gananciaNeta() {
        if (!evento.terminado()) {
            return BigDecimal.ZERO;
        }
        return tipo.ganancia(evento, favorito, monto);
    }

    /**
     * Retorna el mes del evento
     */
    public Boolean inMonth(Month month) {
        return evento.inMonth(month);
    }

    public void suscribirAPartido(Observer observador) {
        evento.suscribirAPartido(observador);
    }
}
