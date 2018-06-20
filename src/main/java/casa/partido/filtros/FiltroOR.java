package casa.partido.filtros;

import casa.partido.Partido;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroOR implements Filtrable {

    private final Filtrable filtroL;
    private final Filtrable filtroR;

    FiltroOR(Filtrable filtroL, Filtrable filtroR) {
        this.filtroL = filtroL;
        this.filtroR = filtroR;
    }

    @Override
    public List<Partido> filtrar() {
        List<Partido> res = filtroL.filtrar();
        res.addAll(filtroR.filtrar());
        return res.stream().distinct().collect(Collectors.toList());
    }

}
