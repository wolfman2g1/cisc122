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

    /**
     * to string employee
     * @return returns the name and id
     */
    public String toString(){
        return this.name + " " + this.id;
    }



}
