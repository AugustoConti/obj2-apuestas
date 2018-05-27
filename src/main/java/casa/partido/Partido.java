package casa.partido;

import casa.ITipeable;
import casa.partido.deportes.IDeporte;
import casa.partido.estados.EstadoPartido;

import java.time.LocalDateTime;

public class Partido implements IPartido {
    private IDeporte deporte;
    private IOponente local;
    private IOponente visitante;
    private LocalDateTime comienzo;
    private String lugar;
    private String resultado;
    private EstadoPartido estado;

    public Partido(IDeporte deporte, IOponente local, IOponente visitante, LocalDateTime comienzo, String lugar,
                   String resultado, EstadoPartido estado) {
        this.deporte = deporte;
        this.local = local;
        this.visitante = visitante;
        this.comienzo = comienzo;
        this.lugar = lugar;
        this.resultado = resultado;
        this.estado = estado;
    }

    @Override
    public IOponente local() {
        return this.local;
    }

    @Override
    public IOponente visitante() {
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
    public void cancelarApuesta(ITipeable apuesta) throws Exception {
        estado.cancelarApuesta(apuesta);
    }

    @Override
    public void reactivarApuesta(ITipeable apuesta) throws Exception {
        estado.reactivarApuesta(apuesta);
    }
}
