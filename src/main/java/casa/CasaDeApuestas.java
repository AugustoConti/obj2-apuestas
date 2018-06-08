package casa;

import casa.balance.BalanceNotifier;

import java.time.Month;
import java.util.List;

class CasaDeApuestas {
    private List<User> usuarios;
    private BalanceNotifier balanceNotifier;

    /**
     * Constructor. Recibe una lista de usuarios, un historial, y un balancerNotifier
     */
    CasaDeApuestas(List<User> usuarios, BalanceNotifier balanceNotifier) {
        this.usuarios = usuarios;
        this.balanceNotifier = balanceNotifier;
    }

    /**
     * Recibe un mes. Envia a cada usuario el balance (ganancia) del mes
     */
    void notifyBalance(Integer month) {
        for (User u : usuarios) {
            balanceNotifier.notifyBalance(u, month, u.getGanancia(Month.of(month)));
        }
    }
}

