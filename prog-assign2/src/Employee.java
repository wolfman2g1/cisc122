public class Employee {
    protected Integer id;
    protected String name;

    /**
     * Constructor to create employee
     * @param n
     * @param i
     */
    public Employee (Employee n, int i){
        this.name = n;
        this.id = i;

    }
    public Employee(){

    }



}
