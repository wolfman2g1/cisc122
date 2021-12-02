import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeMap {
  public static void main(String args[]){
      String file;
      try {
          file = JOptionPane.showInputDialog("Enter file path");
          Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
          while (sc.hasNext()){
              String name = sc.next();
              int id = sc.nextInt();
            Employee e = new Employee(id,name);

          }
      }
      catch (IOException e){

      }

  }

  private Map<Integer,Employee> mappedEmployee(Employee e) {
        Map <Integer, Employee> employeeMap = new HashMap<>();
        employeeMap.put(e.id,e.name);
        return employeeMap;
    }

}
