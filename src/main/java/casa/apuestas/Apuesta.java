package casa.apuestas;

import casa.apuestas.estados.EstadoApuesta;
import casa.apuestas.tipos.TipoApuesta;

import java.math.BigDecimal;

public class Apuesta {
    private BigDecimal monto;
    private String favorito;
    private Evento evento;
    private TipoApuesta tipo;
    private EstadoApuesta estado;

    public void cancelar(){

    }

    public void reactivar(){

    }

    public BigDecimal gananciaBruta() {
        return new BigDecimal(0);
    }

    public BigDecimal gananciaNeta() {
        return gananciaBruta().subtract(monto);
    }

    public boolean inMonth(Integer month) {
        return evento.inMonth(month);
    }
}
