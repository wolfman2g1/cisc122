import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * test harnes
 */
public class Driver {
    public static void main(String args[]) {
        String file;
        try { // get file from user
            file = JOptionPane.showInputDialog("Enter file path");
            Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
            EmployeeMap eM = new EmployeeMap(); // <-- here

            while (sc.hasNext()) {
                int id = sc.nextInt();
                String name = sc.next();
                Employee e = new Employee(name, id);

                eM.insert(e);

            }
            // infinite loop to keep the program going until exit by user
            while (true) {
                String search = JOptionPane.showInputDialog("Search for a name");
                if ("done".equals(search)){ // exit is the user types this in
                    System.exit(0);
                }

               else if (!search.matches("[a-zA-Z]*")) { // check for string
                    throw new InputMismatchException();
                } else {

                    Employee s1 = eM.getEmployee(search);
                    if (!s1.name.equals(search)) {

                        JOptionPane.showMessageDialog(null, search + " " + " Not Found!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Found" + " " + s1.name + " " + "ID" + " " + s1.id);
                    }

                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, " File Not Found!" + e.getMessage());

        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, " Names only please!");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,  " Not Found!");
            System.exit(0);
        }


    }


}


