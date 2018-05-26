package casa.balance;

import casa.User;

import java.math.BigDecimal;

public class TextMessageBalanceNotifier implements BalanceNotifier {
	@Override
    public void notifyBalance(User user, Integer month, BigDecimal monthlyBalance)
	{
		// envío
	}
}
