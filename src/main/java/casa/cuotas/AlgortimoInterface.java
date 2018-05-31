package casa.cuotas;

import casa.partido.PartidoInterface;

import java.math.BigDecimal;

public interface AlgortimoInterface {

    /*algoritmo para ganador local */
    BigDecimal local(PartidoInterface p);
    /*algoritmo para empate */
    BigDecimal empate(PartidoInterface p);
    /*algoritmo para ganador visitante */
    BigDecimal visitante(PartidoInterface p);
}
