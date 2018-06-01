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

    /**
     * Constructor. Crea un evento. Recibe un partido, y un algoritmo para definir la ganancia
     */
    public Evento(PartidoInterface partido, AlgortimoInterface algoritmo) {
        this.partido = partido;
        // calcula las coutas segun el algoritmo entregado //
        cuotaLocal = algoritmo.local(partido);
        cuotaEmpate = algoritmo.empate(partido);
        cuotaVisitante = algoritmo.visitante(partido);
    }

    /**
     * Recibe un mes y retorna true si el partido
     */
    public boolean inMonth(Month month) {
        return partido.inMonth(month);
    }

    /**
     * Cancela la apuesta del partico, si no puede lanza una excepcion
     */
    public void cancelarApuesta(TipeableInterface apuesta) throws Exception {
        partido.cancelarApuesta(apuesta);
    }

    /**
     * Reactiva la apuesta del partico, si no puede lanza una excepcion
     */
    public void reactivarApuesta(TipeableInterface apuesta) throws Exception {
        partido.reactivarApuesta(apuesta);
    }

    /**
     * Le pregunta al pertido si termino. retorna true si el mismo termino
     */
    public boolean terminado() {
        return partido.terminado();
    }

    /**
     * Recibe un favorito, retorna true si el favorito es igual al ganador del partido
     */
    public boolean acierto(Ganador favorito) {
        return partido.acierto(favorito);
    }

    /**
     * Calcula las coutas para los posibles resultados y retorna la misma
     */
    public BigDecimal cuota(Ganador favorito) {

        BigDecimal cuota = null;
        switch(favorito) {
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
