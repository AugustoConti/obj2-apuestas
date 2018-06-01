package casa;

import casa.balance.BalanceNotifier;

import java.time.Month;
import java.util.List;

class Home {
    private List<User> usuarios;
    private HistorialInterface historial;
    private BalanceNotifier balanceNotifier;

    /**
     * Constructor. Recibe una lista de usuarios, un historial, y un balancerNotifier
     */
    Home(List<User> usuarios, HistorialInterface historial, BalanceNotifier balanceNotifier) {
        this.usuarios = usuarios;
        this.historial = historial;
        this.balanceNotifier = balanceNotifier;
    }

    /**
     * Recibe un mes. Envia a cada usuario el balance (ganancia) del mes
     */
    void notifyBalance(Integer month) {
        for(User u : usuarios) {
            balanceNotifier.notifyBalance(u, month, u.getGanancia(Month.of(month)));
        }
    }
}

