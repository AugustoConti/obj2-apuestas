package casa.apuestas.tipos;

import casa.IEstado;
import casa.apuestas.Evento;
import casa.apuestas.tipos.estados.Activa;
import casa.apuestas.tipos.estados.EstadoApuesta;

import java.math.BigDecimal;

public class Segura implements TipoApuesta, IEstado {
    private EstadoApuesta estado;

    public Segura() {
        this.estado = new Activa();
    }

    public void setEstado(EstadoApuesta nuevoEstado){ estado = nuevoEstado; }

    @Override
    public void cancelar(Evento evento) throws Exception {
        estado.cancelar(evento, this);
    }

    @Override
    public void reactivar(Evento evento) throws Exception {
        estado.reactivar(evento, this);
    }

    @Override
    public BigDecimal ganancia(Evento evento, String favorito, BigDecimal monto) {
        return estado.ganancia(evento, favorito, monto);
    }
}
