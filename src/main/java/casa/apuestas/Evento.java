package casa.apuestas;

import casa.TipeableInterface;
import casa.cuotas.AlgortimoInterface;
import casa.partido.PartidoInterface;

import java.math.BigDecimal;

public class Evento {

    private PartidoInterface partido;
    private BigDecimal cuotaLocal;
    private BigDecimal cuotaEmpate;
    private BigDecimal cuotaVisitante;

    public Evento(PartidoInterface partido, AlgortimoInterface algoritmo) {
        this.partido = partido;
        cuotaLocal = algoritmo.local(partido);
        cuotaEmpate = algoritmo.empate(partido);
        cuotaVisitante = algoritmo.visitante(partido);
    }

    public boolean inMonth(Integer month) {
        return partido.inMonth(month);
    }

    public void cancelarApuesta(TipeableInterface apuesta) throws Exception {
        partido.cancelarApuesta(apuesta);
    }

    public void reactivarApuesta(TipeableInterface apuesta) throws Exception {
        partido.reactivarApuesta(apuesta);
    }

    public boolean terminado() {
        return partido.terminado();
    }

    public boolean acierto(String favorito) {
        return partido.acierto(favorito);
    }

    public BigDecimal cuota(String favorito) {
        switch (favorito){
            case "L": return cuotaLocal;
            case "E": return cuotaEmpate;
            case "V": return cuotaVisitante;
            default: return BigDecimal.ZERO;
        }
    }
}
