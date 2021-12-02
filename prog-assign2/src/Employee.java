import java.util.HashMap;
import java.util.Map;

public class Employee {
    protected Integer id;
    protected String name;

    /**
     * Constructor to create employee
     * @param n
     * @param i
     */
    public Employee (String n, int i){
        this.name = n;
        this.id = i;

    }
    public Employee(){

    }
    private Map<Integer,String> mappedEmployee(Employee e) {
        Map <Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(e.id,e.name);
        return employeeMap;
    }


}
