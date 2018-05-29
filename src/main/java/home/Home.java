package home;
import casa.HistorialInterface;
import casa.User;
import casa.balance.BalanceNotifier;

import java.util.List;

public class Home {
    private List<User> usuarios;
    private HistorialInterface historial;
    private BalanceNotifier balanceNotifier;

    public Home(List<User> usuarios, HistorialInterface historial, BalanceNotifier balanceNotifier) {
        this.usuarios = usuarios;
        this.historial = historial;
        this.balanceNotifier = balanceNotifier;
    }

    public void notifyBalance(Integer month){
        for(User u : usuarios){
            balanceNotifier.notifyBalance(u, month, u.getGanancia(month));
        }
    }
}

