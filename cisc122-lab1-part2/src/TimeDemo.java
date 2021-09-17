import java.util.Scanner;

/** This program demonstrates the Time class. */
public class TimeDemo {
	public static void main(String[] args)    {
		Scanner keyboard = new Scanner(System.in);
		char answer = 'Y';
		String enteredTime; String response;
		char entry = Character.toUpperCase(answer);
		while (entry == 'Y')
				{
				System.out.print("Enter a military time " + "using the ##:## format: ");
				enteredTime = keyboard.nextLine();
				Time now = new Time (enteredTime);
				System.out.println("Do you want to enter " + "another (Y/N)? ");
				response = keyboard.nextLine();
				answer = response.charAt(0);
				}
		while(entry != 'Y') { // just a place to exit the program
			System.exit(0);
		}
}
}