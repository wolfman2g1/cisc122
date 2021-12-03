import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
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
            while (sc.hasNext()) {
                int id = sc.nextInt();
                String name = sc.next();
                Employee e = new Employee(name, id);
                EmployeeMap eM = new EmployeeMap();
                eM.insert(e);
                // System.out.println(eM.getEmployee(e.name).toString());
                String search = JOptionPane.showInputDialog("Search for a name");
                if (!search.matches("[a-zA-Z]*")) { // check for string
                    throw new InputMismatchException();
                } else {

                    Employee s1 = eM.getEmployee(search);
                    if (s1.name.equals(search)) {
                        JOptionPane.showMessageDialog(null, "Found" + " " + s1.name + " " + "ID" + " " + s1.id);
                    } else {
                        JOptionPane.showMessageDialog(null, search + " " + " Not Found!");
                    }


                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null,  " Names only please!");
        }
        catch (NullPointerException e){
            System.exit(0);
        }

    }


}


