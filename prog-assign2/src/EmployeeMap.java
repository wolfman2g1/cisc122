import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeMap {
  Map <String, Employee> employeeMap = new HashMap<>();

 public void insert(Employee e){
   employeeMap.put(e.name,e);
 }
  public Employee getEmployee( String i){
    if(employeeMap.containsKey(i)){
      return employeeMap.get(i);
    }
    else {
      return null;
    }
    
  }
}
