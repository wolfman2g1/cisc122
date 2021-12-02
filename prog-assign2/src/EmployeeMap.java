
public class EmployeeMap  {
  public static void main(String args[]){
    Employee e1 = new Employee(119930, "ted");
      
  }
  
  private Map<Integer,Employee> mappedEmployee(Employee e) {
        Map <Integer, Employee> employeeMap = new HashMap<>();
        employeeMap.put(e.id,e.name);
        return employeeMap;
    }

}
