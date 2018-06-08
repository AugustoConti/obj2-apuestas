package casa.cuotas;

import casa.partido.Partido;

import java.math.BigDecimal;

public interface CuotaInterface {

    BigDecimal local(Partido p);

    BigDecimal empate(Partido p);

    BigDecimal visitante(Partido p);

}
