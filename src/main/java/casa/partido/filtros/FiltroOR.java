package casa.partido.filtros;

import casa.partido.Partido;

import java.util.List;

public class FiltroOR implements FiltroInterface {

    private final FiltroInterface filtroL;
    private final FiltroInterface filtroR;

    FiltroOR(FiltroInterface filtroL, FiltroInterface filtroR) {
        this.filtroL = filtroL;
        this.filtroR = filtroR;
    }

    @Override
    public List<Partido> filtrar() {
        List<Partido> res = filtroL.filtrar();
        res.addAll(filtroR.filtrar());
        return res;
    }
}
