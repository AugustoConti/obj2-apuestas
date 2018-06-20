package casa;

import casa.balance.BalanceNotifier;
import casa.partido.Partido;

import java.time.Month;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class CasaDeApuestas implements Observer {
    private final List<User> usuarios;
    private final Historial historial;

    /**
     * Constructor. Recibe una lista de usuarios
     */
    CasaDeApuestas(List<User> usuarios, Historial historial) {
        this.usuarios = usuarios;
        this.historial = historial;
    }

    void addPartido(Partido partido) {
        partido.addObserver(this);
        historial.addPartido(partido);
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

