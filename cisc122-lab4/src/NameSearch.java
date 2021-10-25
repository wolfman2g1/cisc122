import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author R Jones
 * this program reads needs from and file and allows them to be searched
 */
public class NameSearch {
    private static String[] names = new String[65]; // a place to hold the names.

    public static void main(String[] args) throws Exception {
        final int NAME_SIZE = names.length;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\RyJon\\Documents\\java\\cisc122-lab4\\src\\names.txt"));
            for (int i = 0; i < names.length; i++) {
                names[i] = reader.readLine();
            }
            sort(names); // call the sorting algo

        } catch (IOException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        // ask user for name to find
        System.out.println(" Please enter a name to search for");
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toUpperCase(Locale.ROOT);
        // check for strings onl
        if (!input.matches("[A-Za-z]*")) { // make sure we only get characters ( string)
            throw new IOException("Strings only please");
        } else {
            int find = search(names, input);
            if (find == -1) {
                System.out.println(" The name you entered is not on the list");
            } else {
                System.out.println(" That name is number" + " " + find + " " + " on the list");
            }
        }


    }

    /**
     * This method sorts the names in ascending order
     *
     * @param arr and array of names to be sorted
     */
    public static void sort(String[] arr) {
        final int NAME_SIZE = names.length;
        for (int i = 0; i < NAME_SIZE - 1; i++) {
            for (int k = i + 1; k < NAME_SIZE; k++) {
                if (names[i].compareTo(names[k]) > 0) {
                    String temp = names[i];
                    names[i] = names[k];
                    names[k] = temp;
                }
            }
        }
    }

    /**
     * loop through the array to find a given name
     *
     * @param arr    array of names
     * @param target the name to search for
     * @return true or false
     */
    public static int search(String[] arr, String target) {
        final int NAME_SIZE = names.length;
        int min = 0;
        int max = NAME_SIZE - 1;
        int mid;
        while (min <= max) {
            mid = (min + max) / 2;
            if (names[mid].compareTo(target) < 0) {
                min = mid + 1;

            } else if (names[mid].compareTo(target) > 0) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
