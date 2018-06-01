package home;

import casa.HistorialInterface;
import casa.User;
import casa.balance.BalanceNotifier;

import java.time.Month;
import java.util.List;

public class Home {
    private List<User> usuarios;
    private HistorialInterface historial;
    private BalanceNotifier balanceNotifier;

    /** Constructor. Recibe una lista de usuarios, un historial, y un balancerNotifier */
    public Home(List<User> usuarios, HistorialInterface historial, BalanceNotifier balanceNotifier) {
        this.usuarios = usuarios;
        this.historial = historial;
        this.balanceNotifier = balanceNotifier;
    }

    /**  Recibe un mes. Envia a cada usuario el balance (ganancia) del mes */
    public void notifyBalance(Integer month) {
        for(User u : usuarios) {
            balanceNotifier.notifyBalance(u, month, u.getGanancia(Month.of(month)));
        }
    }
}

