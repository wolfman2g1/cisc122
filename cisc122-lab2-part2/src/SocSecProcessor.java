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
			boolean isValidSsn = isValid(ssn);
			if (isValidSsn) {
				System.out.println(name + " " + ssn + " " + "is Valid");
				System.out.println(" Continue ?");
				String again = sc.nextLine();

			}
		} catch (SocSecException e) {
			System.out.println(e.getMessage());

		}
		sc.close();

	}


	public static boolean isValid(String ssn) throws SocSecException {
		boolean check;
		if (ssn.length() < 11) {
			check = false;
			throw new SocSecException("not a vaild social security number!");
		} else if (!ssn.matches("^[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]$")) {
			throw new SocSecException("not a vaild social security number!");

		} else {
			check = true;
		}
		return true;
	}

}
