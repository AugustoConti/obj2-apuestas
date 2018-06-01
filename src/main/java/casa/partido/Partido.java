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

    /**
     * Retorna el oponente local del partido
     */
    @Override
    public OponenteInterface local() {
        return this.local;
    }

    /**
     * Retorna el openente visitante del partido
     */
    @Override
    public OponenteInterface visitante() {
        return this.visitante;
    }

    /**
     * Retorna true si el estadado del partido es terminado
     */
    @Override
    public boolean terminado() {
        return estado.terminado();
    }

    /**
     * Recibe un  favorito . Retorna true si el ganador del partido es igual a favorito
     */
    @Override
    public boolean acierto(Ganador favorito) {
        return ganador == favorito;
    }

    /**
     * Recibe un mes. Retorna true si el mes del comienzo del partido es igual al mes que recibe
     */
    @Override
    public boolean inMonth(Month month) {
        return comienzo.getMonth() == month;
    }

    /**
     * Recibe una apuesta. Cancela la apuesta . Lanza una excepcion si la misma no puede ser cancelada
     */
    @Override
    public void cancelarApuesta(TipeableInterface apuesta) throws Exception {
        estado.cancelarApuesta(apuesta);
    }

    /**
     * Recibe una apuesta. Reactiva la misma. Lanza una excepcion si la misma no puede ser reactivada
     */
    @Override
    public void reactivarApuesta(TipeableInterface apuesta) throws Exception {
        estado.reactivarApuesta(apuesta);
    }

    /**
     * cambia el estado del partido al siguiente estado que le corresponde
     */
    @Override
    public void nextState() {
        estado.nextState(this);
    }

    /**
     * Recibe un estado. Setea el estado del partido con el que recibe
     */
    @Override
    public void setState(EstadoPartido estado) {
        this.estado = estado;
    }

    public Ganador getGanador() {
        return ganador;
    }
}
