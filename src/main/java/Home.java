import casa.IHistorial;
import casa.User;
import casa.balance.BalanceNotifier;

import java.util.List;

public class Home {
    private List<User> usuarios;
    private IHistorial historial;
    private BalanceNotifier balanceNotifier;

    public Home(List<User> usuarios, IHistorial historial, BalanceNotifier balanceNotifier) {
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

