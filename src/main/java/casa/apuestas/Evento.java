package casa.apuestas;

import casa.cuotas.IAlgoritmo;
import casa.partido.IPartido;

import java.math.BigDecimal;

public class Evento {

    private IPartido partido;
    private BigDecimal cuotaLocal;
    private BigDecimal cuotaEmpate;
    private BigDecimal cuotaVisitante;

    public Evento(IPartido partido, IAlgoritmo algoritmo) {
        this.partido = partido;
        cuotaLocal = algoritmo.local(partido);
        cuotaEmpate = algoritmo.empate(partido);
        cuotaVisitante = algoritmo.visitante(partido);
    }



    public boolean inMonth(Integer month) {
        return partido.inMonth(month);
    }
}
