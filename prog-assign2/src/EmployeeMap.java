import java.util.HashMap;
import java.util.Map;

/**
 * creates a map from an employee object e
 */
public class EmployeeMap {
  Map <String, Employee> employeeMap = new HashMap<>();

    /**
     * pushes an employee object on to the map
     * @param e an employee object
     */
 public void insert(Employee e){
   employeeMap.put(e.name,e);
 }

    /**
     * gets all keys from the map
     * @param i key to search for
     * @return an employee map of all key, value pairs
     */
  public Employee getEmployee( String i){
    if(employeeMap.containsKey(i)){
      return employeeMap.get(i);
    }
    else {
      return null;
    }
    
  }
}
