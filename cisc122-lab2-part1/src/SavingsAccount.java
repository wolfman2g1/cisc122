/** this class simulates a savings account. */
public class SavingsAccount extends BankAccount {
	private double rate = 2.5;
	private int savingsNumber = 0;
	private String accountNumber;

	public SavingsAccount(String name, double amount) {
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		savingsNumber = savingsNumber + 1;

	}

	public SavingsAccount(SavingsAccount oldAccounts, double amount) {
		super(oldAccounts.getOwner(), amount);
		this.accountNumber = oldAccounts.getAccountNumber();

	}

	public void postInterest() {
		double preInterest = getBalance(); // get the current balance
		double interest = preInterest * rate; // calculate the interest
		deposit(preInterest + interest); // deposit into account

	}

	public String getAccountNumber() {
		return accountNumber;
	}

}
