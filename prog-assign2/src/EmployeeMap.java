import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeMap {
  public Map currentMap =
  public static void main(String args[]){
    Employee e1 = new Employee(119930, "ted");

  }

  private Map<Integer,Employee> mappedEmployee(Employee e) {
        Map <Integer, Employee> employeeMap = new HashMap<>();
        employeeMap.put(e.id,e.name);
        return employeeMap;
    }

}
