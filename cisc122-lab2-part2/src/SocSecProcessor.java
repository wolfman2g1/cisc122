import java.util.Scanner;

public class SocSecProcessor {

	public static void main(String[] args) throws SocSecException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println(" Please enter a name:" + "\n");
			String name = sc.nextLine();
			
			System.out.println(); // insert newline
			System.out.println(" Please enter a ssd:" + "\n");
			String ssn = sc.nextLine();
			}
		catch (SocSecException e) {
			System.out.println(e.getMessage());
			
		}
		

	}

	public static boolean isName(String name) {
		boolean check = true;
		if ( name.length() == 0) {
			System.out.println("You must enter a name");
			check = false;
			
		}
		return check;
		
	}
	public static boolean isValid(String ssn) throws SocSecException  {
		boolean check;
		if (ssn.length() < 11) {
			check = false;
		} else if (!ssn.matches("^[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]$")) {
			throw new SocSecException("not a vaild social security number!");

		} else {
			check = true;
		}
		return check;
	}

}
