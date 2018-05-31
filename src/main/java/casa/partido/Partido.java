package casa.partido;

import casa.TipeableInterface;
import casa.partido.deportes.DeporteInterface;
import casa.partido.estados.EstadoPartido;

import java.time.LocalDateTime;
import java.time.Month;

public class Partido implements PartidoInterface {
    private DeporteInterface deporte;
    private OponenteInterface local;
    private OponenteInterface visitante;
    private LocalDateTime comienzo;
    private String lugar;
    private Ganador ganador;
    private EstadoPartido estado;

    public Partido(DeporteInterface deporte, OponenteInterface local, OponenteInterface visitante,
                   LocalDateTime comienzo, String lugar, Ganador ganador, EstadoPartido estado) {
        this.deporte = deporte;
        this.local = local;
        this.visitante = visitante;
        this.comienzo = comienzo;
        this.lugar = lugar;
        this.ganador = ganador;
        this.estado = estado;
    }

    @Override
    public OponenteInterface local() {
        return this.local;
    }

    @Override
    public OponenteInterface visitante() {
        return this.visitante;
    }

    @Override
    public boolean terminado() {
        return estado.terminado();
    }

    @Override
    public boolean acierto(Ganador favorito) {
        return ganador == favorito;
    }

    @Override
    public boolean inMonth(Month month) {
        return comienzo.getMonth() == month;
    }

    @Override
    public void cancelarApuesta(TipeableInterface apuesta) throws Exception {
        estado.cancelarApuesta(apuesta);
    }

    @Override
    public void reactivarApuesta(TipeableInterface apuesta) throws Exception {
        estado.reactivarApuesta(apuesta);
    }

    @Override
    public void nextState() {
        estado.nextState(this);
    }

    @Override
    public void setState(EstadoPartido estado) {
        this.estado = estado;
    }
}
