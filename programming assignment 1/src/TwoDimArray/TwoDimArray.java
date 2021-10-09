
package TwoDimArray;

public class TwoDimArray {
    private static double[][] twoDimArray;
    private static double total = 0.0;
    private static double avg = 0.0;
    private static int row_size;
    private static int col_size;

    /**
     * no arguement constructor
     */
   public TwoDimArray(){

   }

    /**
     * takes an int array and sets up the twoDim array and initialized the row_size and col_size instance variables
     * @param a
     */
    public  TwoDimArray(int[] a) {
        twoDimArray = new double[a[0]][a[1]];
        row_size= a[0];
        col_size= a[1];
    }

    /**
     * takes a 1d array and maps it to a 2d arrway
     *
     * @param array array of doubles
     */
    public  void loadArray(double[] array) {
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                for (int test = 0; test < array.length; test++)
                    twoDimArray[row][col] = array[test]; // this should assign the index at test to the index of the 2d array
            }
        }
    }

    /**
     * iterates thrgouh the arrary and returns the total
     *
     * @return
     */
    public  double getTotal() {

        // loop through the array and add the values
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[col].length; col++) {
                total += twoDimArray[row][col];
            }
        }
        return total;
    }

    /**
     * takes the average of all the elements in the 2d array
     *
     * @return avg
     */

    public  double getAverage() {
        int sum = 0, count = 0;
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                sum += twoDimArray[row][col];
                count++; // accumulator


            }
        }
        avg = sum / count;
        return avg;
    }

    public  double getColumnTotal(int d) {
        int colTotal = 0;
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                colTotal += twoDimArray[row][d]; // loop through the row but only look at the subscript for the column passed to the method

            }
        }
        return colTotal;

    }

    /**
     * @param f int for the row number
     * @return highest in the row
     */
    public  double getHighestInRow(int f) {
        double highest = 0;
        final int ROW_SIZE = twoDimArray.length;
        for (int i = 0; i < ROW_SIZE; i++) {
            final int COL_SIZE = twoDimArray[f].length;
            for (int j = 0; j < COL_SIZE; j++) {
                if (highest > twoDimArray[f][j]) {
                    highest = twoDimArray[f][j];
                }
            }
        }
        return highest;
    }

    /**
     * Looks for the lowest number in the row passed by calling function
     *
     * @param f
     * @return lowest in row
     */
    public  double getLowestInRow(int f) {
        double lowest = 0;
        final int ROW_SIZE = twoDimArray.length;
        for (int i = 0; i < ROW_SIZE; i++) {
            final int COL_SIZE = twoDimArray[f].length;
            for (int j = 0; j < COL_SIZE; j++) {
                if (lowest < twoDimArray[f][j]) {
                    lowest = twoDimArray[f][j];
                }
            }
        }
        return lowest;
    }

    /**
     * this method calculated the highest value in the array
     * @return  max_value the highest value
     */
    public  double getArrayMaxValue() {
        final int ROW_SIZE = twoDimArray.length;
        double max_value = 0;
        for (int i = 0; i < ROW_SIZE; i++) {
            final int COL_SIZE = twoDimArray[i].length;
            for (int j = 0; j < COL_SIZE; j++) {
                if (max_value > twoDimArray[i][j]) {
                    max_value = twoDimArray[i][j];
                }
            }

        }
        return max_value;
    }
    /**
     * this method calculated the highest value in the array
     * @return min_value the lowest value in the array
     */
    public  double  getArrayMinalue() {
        final int ROW_SIZE = twoDimArray.length;
        double min_Value = 0;
        for (int i = 0; i < ROW_SIZE; i++) {
            final int COL_SIZE = twoDimArray[i].length;
            for (int j = 0; j < COL_SIZE; j++) {
                if (min_Value < twoDimArray[i][j]) {
                    min_Value = twoDimArray[i][j];
                }
            }

        }
        return min_Value;
    }

    /**
     * this method calculates the standard deviation
     * @return the standard deviation
     */
    public  double calcStdDev() {
        double sum =0.0 , dev= 0.0, avg = 0.0;
        int counter =0;
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                sum += twoDimArray[row][col];
                counter++;

            }
        }
        avg = sum/counter;
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                dev += Math.pow(twoDimArray[row][col] - avg, 2);

            }
        }
        return Math.sqrt(dev/counter);

    }

    /**
     * this method finds a number in the array
     * @return true or false if value is present
     */
    public  boolean findValue(double check) {
        final int ROW_SIZE = twoDimArray.length;
        boolean test = false;
        for ( int i =0; i < ROW_SIZE; i++ ){
            final int COL_SIZE = twoDimArray[i].length;
            for( int j =0; j < COL_SIZE; j++){
                if (twoDimArray[i][j] == check){
                    test = true;
                }
            }
        }
        return test;
    }

    /**
     * gets the size of the row
     * @return row
     */
    public int getRow(){
        int row = row_size;
        return row;
    }

    /**
     * gets the size of the column
     * @return col
     */
    public int getCol(){
        int col = col_size;
        return col;
    }

}





