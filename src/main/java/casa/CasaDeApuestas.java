package casa;

import casa.balance.BalanceNotifier;

import java.time.Month;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CasaDeApuestas implements Observer {
    private final List<User> usuarios;

    /**
     * Constructor. Recibe una lista de usuarios
     */
    CasaDeApuestas(List<User> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Envia a cada usuario el balance (ganancia) del mes
     */
    void notifyBalance(BalanceNotifier balanceNotifier, Integer month) {
        usuarios.forEach(user -> balanceNotifier.notifyBalance(user, month, user.getGanancia(Month.of(month))));
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

