
package TwoDimArray;

public class TwoDimArray {
    private static double[][] twoDimArray;
    private static double total = 0.0;
    private static double avg = 0.0;

    /**
     * sets the length of twoDimArray
     *
     * @param a int[]
     */

    public static void setBounds(int[] a) {
        twoDimArray = new double[a[0]][a[1]];
    }

    /**
     * takes a 1d array and maps it to a 2d arrway
     *
     * @param array array of doubles
     */
    public static void loadArray(double[] array) {
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
    public static double getTotal() {

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

    public static double getAverage() {
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

    public static double getColumnTotal(int d) {
        int colTotal = 0;
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                colTotal += twoDimArray[row][d]; // loop through the row but only look at the subscript for the column passed to the method

            }
        }
        return colTotal;

    }

    /**
     *
     * @param f int for the row number
     * @return highest in the row
     */
    public static double getHighestInRow(int f) {
        double holder = 0;
        for (int i = f; i < twoDimArray[i].length; ) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                 holder = twoDimArray[i][j];
                if (twoDimArray[i][j] > twoDimArray[i][j]) {
                    holder = twoDimArray[i][j];
                }
            }
        }
        return holder;
// TODO this doesn't look right
    }
}





