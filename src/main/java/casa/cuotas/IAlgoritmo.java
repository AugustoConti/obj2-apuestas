package casa.cuotas;

import casa.partido.IPartido;

import java.math.BigDecimal;

public interface IAlgoritmo {
    BigDecimal local(IPartido p);

    BigDecimal empate(IPartido p);

    BigDecimal visitante(IPartido p);
}
