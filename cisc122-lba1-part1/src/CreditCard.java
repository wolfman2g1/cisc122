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

	}
	/*
	 * constructor
	 * @param Money creditLimit
	 * @param Money balance
	 */
	public CreditCard(Money creditLimit, Money balance, Person owner) {
		this.balance = balance;
		this.creditLimit = creditLimit;
		this.owner = owner;
		
	}
  /*
   *  return a money object
   */
	public Money getBalance() {
		return new Money(balance);

	}
	/*
	 * return a creditLimit money object
	 */

	public Money getCreditLimit() {
		return new Money(creditLimit);

	}

	public String getPersonals() {
		return  " ";
	}

	/*
	 * 
	 */
	public void charge(Money amount) {

	}

	/*
	 * 
	 */
	public void payment(Money amount) {

	}

}
