import java.util.Locale;
import java.util.Scanner;

/**
 * uses the SocSecException to throw errors if the social security number isn't in the correct format
 */
public class SocSecProcessor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            try {


                System.out.println(" Please enter a name:" + "\n");
                String name = sc.nextLine();
                System.out.println(); // insert newline
                System.out.println(" Please enter a ssd:" + "\n");
                String ssn = sc.nextLine();
                boolean isValidSsn = isValid(ssn);
                if (isValidSsn) {
                    System.out.println(name + " " + ssn + " " + "is Valid");
                    System.out.println(" Continue ? y/n");
                    String again = sc.nextLine().toLowerCase();
                     if (again.equals("n")){
                            System.out.println(" Good bye");
                        break;

                    }

                }
            } catch (SocSecException e) {
                System.out.println(e.getMessage());
                System.out.println(" Continue ? y/n");
                String again = sc.nextLine().toLowerCase();
                if (again.equals("n")){
                    System.out.println(" Good bye");
                    break;

                }

            }
           // sc.close();
        }


    }

    /**
     * checks if the social security number format is valid.
     *
     * @param ssn
     * @return check
     * @throws SocSecException if the length of the string is less than 11 or the format doesn't match the regex pattern
     */
    public static boolean isValid(String ssn) throws SocSecException {
        boolean check;
        if (ssn.length() < 11 || ssn.length() > 11) {
            check = false;
            throw new SocSecException("Wrong number of characters" + " " + ssn);
        } else if (!ssn.matches("^[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]$")) { // since this is a known pattern a regex makes more sense that looking for characters in the string
            throw new SocSecException("not a vaild social security number!");

        } else {
            check = true;
        }
        return true;
    }
}


