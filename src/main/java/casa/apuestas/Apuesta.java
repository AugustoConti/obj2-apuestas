package casa.apuestas;

import casa.TipeableInterface;
import casa.apuestas.tipos.TipoApuestaInterface;

import java.math.BigDecimal;

public class Apuesta implements TipeableInterface {
    private BigDecimal monto;
    private String favorito;
    private Evento evento;
    private TipoApuestaInterface tipo;

    public Apuesta(BigDecimal monto, String favorito, Evento evento, TipoApuestaInterface tipo) {
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

    public BigDecimal gananciaBruta() throws Exception {
        return gananciaNeta().add(monto);
    }

    public BigDecimal gananciaNeta() throws Exception {
        if (!evento.terminado()) {
            throw new Exception("El evento no ha terminado");
        }
        return tipo.ganancia(evento, favorito, monto);
    }

    public boolean inMonth(Integer month) {
        return evento.inMonth(month);
    }
}
