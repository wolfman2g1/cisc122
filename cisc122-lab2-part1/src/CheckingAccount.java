/** this class simulates a checking account */
public class CheckingAccount extends BankAccount {
	private static final double FEE = .15;

	public CheckingAccount(String name, double amount) {
		super(name, amount);
		String currentAccountNumber = getAccountNumber();
		setAccountNumber(currentAccountNumber + "-10") ;

	}
	@Override
	public boolean withdraw(double amount) {
		boolean done = true;
		double prevBalance = getBalance();
		if(amount + prevBalance > prevBalance) {
			double newBalance = amount + FEE;
			super.withdraw(newBalance);
		} else {
			done = false;
		}
		return done;
	}

}
