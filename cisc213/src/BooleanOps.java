/**
 * this class calculates logical expressions
 * @author Ryan Jones
 */


public class BooleanOps {
    /**
     *  takes two boolean values and returns a result of a logical implication
     * @param  a
     * @param  b
     * @return true or false
     */
    private static boolean imply(boolean a, boolean b){
        if(a == true && b == false ) {
            return false;
        }
        else {
            return true;
        }
    }
    /**
     *  takes two boolean values and returns a result of a logical XOR
     * @param  a
     * @param  b
     * @return true or false
     */
    private static boolean xor(boolean a, boolean  b){
        if(a == true && b == true){
            return false;
        }
        else {
            return true;
        }
    }
    /**
     *  takes two boolean values and returns a result of a logical XOR
     * @param  a
     * @param  b
     * @return true or false
     */
    private static boolean nand( boolean a, boolean b){
        if ( a == true && b == true){
            return false;
        }
        else {
            return true;
        }

    }
    /**
     *  takes two boolean values and returns a result of a logical Equality
     * @param  a
     * @param  b
     * @return true or false
     */
    private static boolean eq(boolean a, boolean b){
        int result = Boolean.compare(a,b);
        if( result == 0){
            return true;

        }
        else {
            return false;
        }
    }
    /**
     *  takes two boolean values and returns a result of a logical NOR.
     * @param  a
     * @param  b
     * @return true or false
     */
    private static boolean nor(boolean a, boolean b){
        if( a == false && b == false) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        // Implication
        System.out.println("False  if and only if a is true and b is false:" + " " + imply(true,false));
        // NOR
        System.out.println("True  if and only if a and b are false:" + " " + nor(false,false));
        // Equality
        System.out.println("True  if and only if a and b are equal:" + " " + eq(false,false));
        // NAND
        System.out.println("False  if and only if a and b are true:" + " " + nand(false,false));
        //XOR
        System.out.println("False  if and only if a and b are true:" + " " + xor(true,true));
    }

}
