// This class looks up credit card balances
public class CreditCard {
	private Money balance;
	private Money creditLimit; 
	private Person owner;

	/**
	 * constructor
	 * 
	 * @param newCardHolder Person Object
	 * @param limit         Money Object
	 */
	public CreditCard(Person newCardHolder, Money limit) {
		balance = new Money(0); // initialize the balance to 0
		creditLimit = new Money(0); // initialize credit limit to 0. 
		this.creditLimit = limit;
		this.owner = newCardHolder;
		

	}

	/*
	 * constructor
	 * 
	 * @param Money creditLimit
	 * 
	 * @param Money balance
	 */
	public CreditCard(Money creditLimit, Person owner) {

		this.creditLimit = creditLimit;
		this.owner = owner;

	}

	/*
	 * @return a money object
	 */
	public Money getBalance() {
		return new Money(balance);

	}
	/*
	 * @return a creditLimit money object
	 */

	public Money getCreditLimit() {
		return new Money(creditLimit);

	}
/*
 * @return owner.toString
 */
	public String getPersonals() {
		return owner.toString();
	}
 
	/* add to the balance every time something is charged  only if the balance is not greater than the credit limit
	 * 
	 */
	public void charge(Money amount) {
		if ((balance.getDollars() + balance.getCents())+ (amount.getDollars() + amount.getCents()) >= (creditLimit.getDollars() + creditLimit.getCents())) {
			System.out.println(" Exceeds credit limit");
		}
		else {
			System.out.println( "Charge:" + " " + amount);
			balance = balance.add(amount);
		}
	}

	/* subtract from balance when a payment is made
	 * 
	 */
	public void payment(Money amount) {
		System.out.println("Payment:" + " " + amount);
		balance = balance.subtract(amount);

	}

}
