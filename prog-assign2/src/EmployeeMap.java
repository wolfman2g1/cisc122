import java.util.HashMap;
import java.util.Map;

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
