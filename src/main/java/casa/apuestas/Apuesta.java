package casa.apuestas;

import casa.apuestas.tipos.TipoApuesta;

import java.math.BigDecimal;

public class Apuesta {
    private BigDecimal monto;
    private String favorito;
    private Evento evento;
    private TipoApuesta tipo;

    public Apuesta(BigDecimal monto, String favorito, Evento evento, TipoApuesta tipo) {
        this.monto = monto;
        this.favorito = favorito;
        this.evento = evento;
        this.tipo = tipo;
    }

    public void cancelar() throws Exception {
        tipo.cancelar(evento);
    }

    public void reactivar() throws Exception {
        tipo.reactivar(evento);
    }

    public BigDecimal gananciaBruta() throws Exception {
        return gananciaNeta().add(monto);
    }

    public BigDecimal gananciaNeta() throws Exception {
        if (!evento.terminado())
            throw new Exception("El evento no ha terminado");
        return tipo.ganancia(evento, favorito, monto);
    }

    public boolean inMonth(Integer month) {
        return evento.inMonth(month);
    }
}
