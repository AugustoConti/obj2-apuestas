package casa.partido.filtros;

import casa.partido.Partido;

import java.util.List;

public class FiltroAND implements Filtrable {

    private final Filtrable filtroL;
    private final Filtrable filtroR;

    FiltroAND(Filtrable filtroL, Filtrable filtroR) {
        this.filtroL = filtroL;
        this.filtroR = filtroR;
    }

    @Override
    public List<Partido> filtrar() {
        List<Partido> res = filtroL.filtrar();
        res.retainAll(filtroR.filtrar());
        return res;
    }
}
