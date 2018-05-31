package casa.apuestas;

import casa.TipeableInterface;
import casa.cuotas.AlgortimoInterface;
import casa.partido.Ganador;
import casa.partido.PartidoInterface;

import java.math.BigDecimal;
import java.time.Month;

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

    public boolean inMonth(Month month) {
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

    public boolean acierto(Ganador favorito) {
        return partido.acierto(favorito);
    }

    public BigDecimal cuota(Ganador favorito) {

        BigDecimal cuota = null;
        switch (favorito) {
            case LOCAL:
                cuota = cuotaLocal;
                break;
            case NINGUNO:
                cuota = cuotaEmpate;
                break;
            case VISITANTE:
                cuota = cuotaVisitante;
                break;
        }

        return cuota;
    }
}
