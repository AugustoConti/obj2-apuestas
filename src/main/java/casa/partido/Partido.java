package casa.partido;

import casa.TipeableInterface;
import casa.partido.estados.EstadoPartido;
import casa.partido.estados.PartidoNoEmpezado;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Observable;

public class Partido extends Observable {
    private final Deporte deporte;
    private final OponenteInterface local;
    private final OponenteInterface visitante;
    private final LocalDateTime fecha;
    private final String lugar;
    private final Ganador ganador;
    private EstadoPartido estado;

    public Partido(Deporte deporte, OponenteInterface local, OponenteInterface visitante,
                   LocalDateTime fecha, String lugar, Ganador ganador) {
        this.deporte = deporte;
        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
        this.lugar = lugar;
        this.ganador = ganador;
        this.estado = new PartidoNoEmpezado();
    }

    /**
     * Retorna el oponente local del partido
     */
    public OponenteInterface getLocal() {
        return this.local;
    }

    /**
     * Retorna el openente visitante del partido
     */
    public OponenteInterface getVisitante() {
        return this.visitante;
    }

    /**
     * Retorna true si el estadado del partido es terminado
     */
    public Boolean terminado() {
        return estado.terminado();
    }

    /**
     * Recibe un  favorito . Retorna true si el ganador del partido es igual a favorito
     */
    public Boolean acierto(Ganador favorito) {
        return ganador == favorito;
    }

    /**
     * Recibe un mes. Retorna true si el mes del fecha del partido es igual al mes que recibe
     */
    public Boolean inMonth(Month month) {
        return fecha.getMonth() == month;
    }

    /**
     * Recibe una apuesta. Cancela la apuesta . Lanza una excepcion si la misma no puede ser cancelada.
     */
    public void cancelarApuesta(TipeableInterface apuesta) throws Exception {
        estado.cancelarApuesta(apuesta);
    }

    /**
     * Recibe una apuesta. Reactiva la misma. Lanza una excepcion si la misma no puede ser reactivada
     */
    public void reactivarApuesta(TipeableInterface apuesta) throws Exception {
        estado.reactivarApuesta(apuesta);
    }

    /**
     * Cambia el estado del partido al siguiente estado que le corresponde
     */
    public void nextState() {
        estado.nextState(this);
    }

    /**
     * Recibe un estado. Setea el estado del partido con el que recibe
     */
    public void setState(EstadoPartido estado) {
        this.estado = estado;
    }

    /**
     * Avisa a sus observadores que ocurrio un cambio en sus estados.
     */
    public void notificarSuscriptores() {
        setChanged();
        notifyObservers();
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public String getLugar() {
        return lugar;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Boolean conOponente(OponenteInterface oponente) {
        return local == oponente || visitante == oponente;
    }
}
