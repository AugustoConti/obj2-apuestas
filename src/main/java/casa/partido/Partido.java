package casa.partido;

import casa.TipeableInterface;
import casa.partido.deportes.DeporteInterface;
import casa.partido.estados.EstadoPartido;

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
    public boolean acierto(String favorito) throws Exception {
        if (resultado.equals("E") && !deporte.admiteEmpate())
            throw new Exception(String.format("%s no admite empate", deporte.nombre()));
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
}
