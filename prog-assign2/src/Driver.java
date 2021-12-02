import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]){
        String file;
        try {
            file = JOptionPane.showInputDialog("Enter file path");
            Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
            while (sc.hasNext()){
                int id = sc.nextInt();
                String name = sc.next();
                Employee e = new Employee(name, id);
                EmployeeMap eM = new EmployeeMap();
                eM.insert(e);
                System.out.println(eM.getEmployee(e.name).toString());

            }
        }
        catch (IOException e){

        }

    }
}
