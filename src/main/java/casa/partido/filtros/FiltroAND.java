package casa.partido.filtros;

import casa.partido.Partido;

import java.util.List;

public class FiltroAND implements FiltroInterface {

    private final FiltroInterface filtroL;
    private final FiltroInterface filtroR;

    FiltroAND(FiltroInterface filtroL, FiltroInterface filtroR) {
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
