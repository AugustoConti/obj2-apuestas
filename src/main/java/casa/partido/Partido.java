package casa.partido;

import casa.partido.estados.EstadoPartido;

import java.time.LocalDateTime;

public class Partido implements IPartido {
    private Deporte deporte;
    private IOponente local;
    private IOponente visitante;
    private LocalDateTime comienzo;
    private String lugar;
    private String resultado;
    private EstadoPartido estado;

    public Partido(Deporte deporte, IOponente local, IOponente visitante, LocalDateTime comienzo, String lugar,
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
    public boolean inMonth(Integer month) {
        return comienzo.getMonth().getValue() == month;
    }
}
