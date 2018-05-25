package apuestas.cuotas.algoritmos;

import apuestas.partido.IOponente;

import java.math.BigDecimal;

public interface IAlgoritmo {
    BigDecimal local(IOponente a, IOponente b);

    BigDecimal empate(IOponente a, IOponente b);

    BigDecimal visitante(IOponente a, IOponente b);
}
