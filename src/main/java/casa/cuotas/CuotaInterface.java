package casa.cuotas;

import casa.partido.PartidoInterface;

import java.math.BigDecimal;

public interface CuotaInterface {

    BigDecimal local(PartidoInterface p);

    BigDecimal empate(PartidoInterface p);

    BigDecimal visitante(PartidoInterface p);

}
