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

    public Apuesta(BigDecimal monto, Ganador favorito, Evento evento, TipoApuestaInterface tipo) {
        this.monto = monto;
        this.favorito = favorito;
        this.evento = evento;
        this.tipo = tipo;
    }

    public void setTipo(TipoApuestaInterface tipo) {
        this.tipo = tipo;
    }

    public void cancelar() throws Exception {
        tipo.cancelar(evento, this);
    }

    public void reactivar() throws Exception {
        tipo.reactivar(evento, this);
    }

    public BigDecimal gananciaBruta() {
        return gananciaNeta().add(monto);
    }

    public BigDecimal gananciaNeta() {
        if (!evento.terminado()) {
            return BigDecimal.ZERO;
        }
        return tipo.ganancia(evento, favorito, monto);
    }

    public boolean inMonth(Month month) {
        return evento.inMonth(month);
    }
}
