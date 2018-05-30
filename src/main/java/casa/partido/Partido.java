package casa.partido;

import casa.TipeableInterface;
import casa.partido.deportes.DeporteInterface;
import casa.partido.estados.EstadoPartido;
import casa.partido.estados.PartidoNoEmpezado;

import java.time.LocalDateTime;

public class Partido implements PartidoInterface {
    private DeporteInterface deporte;
    private OponenteInterface local;
    private OponenteInterface visitante;
    private LocalDateTime comienzo;
    private String lugar;
    private String resultado;
    private EstadoPartido estado;

    public Partido(DeporteInterface deporte, OponenteInterface local, OponenteInterface visitante,
                   LocalDateTime comienzo, String lugar, String resultado, EstadoPartido estado) {
        this.deporte = deporte;
        this.local = local;
        this.visitante = visitante;
        this.comienzo = comienzo;
        this.lugar = lugar;
        this.resultado = resultado;
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
    public boolean acierto(String favorito) {
        return resultado.equals(favorito);
    }

    @Override
    public boolean inMonth(Integer month) {
        return comienzo.getMonth().getValue() == month;
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
