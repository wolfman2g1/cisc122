package application;
import java.util.Arrays;

/**
 * This class handles all the business logic for the TwoDimDriver application
 *
 * @author Ryan Jones
 * @version 1.0 Oct 2021
 */
public class TwoDimArray {
    private static double[][] twoDimArray;
    private double total = 0.0;
    private static int row_size;
    private static int col_size;

    /**
     * no arguement constructor
     */
    public TwoDimArray() {

    }

    /**
     * takes an int array and sets up the twoDim array and initialized the row_size and col_size instance variables
     *
     * @param a int array to be used to set up 2D array
     */
    public TwoDimArray(int[] a) {
        twoDimArray = new double[a[0]][a[1]];
        row_size = a[0];
        col_size = a[1];
    }

    /**
     * takes a 1d array and maps it to a 2d arrway
     *
     * @param array array of doubles
     */
    public void loadArray(double[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                twoDimArray[row][col] = array[row][col]; // this should assign the index at test to the index of the 2d array
            }
        }
    }

    /**
     * iterates thrgouh the arrary and returns the total
     *
     * @return the total for all values in the array
     */
    public double getTotal() {

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
     * @return avg the average of all elements in the 2D array
     */

    public double getAverage() {
        int sum = 0, count = 0;
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                sum += twoDimArray[row][col];
                count++; // accumulator


            }
        }
        return sum / count;
    }

    /**
     * @param d column to search
     * @return the total of all elements in column
     */
    public double getColumnTotal(int d) {
        double colTotal = 0;
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                colTotal += twoDimArray[row][d]; // loop through the row but only look at the subscript for the column passed to the method

            }
        }
        return colTotal;

    }

    /**
     * calculates the total of all elements in the row
     *
     * @param r which row to operate on
     * @return the total of the row
     */
    public double getRowTotal(int r) {
        double rowTotal = 0.0;
        for (int col = 0; col < twoDimArray[r].length; col++) {
            rowTotal += twoDimArray[r][col];
        }
        return rowTotal;
    }

    /**
     * @param f int for the row number
     * @return highest in the row
     */
    public double getHighestInRow(int f) {
        double highest = 0;
        final int ROW_SIZE = twoDimArray.length;
        for (int i = 0; i < ROW_SIZE; i++) {
            final int COL_SIZE = twoDimArray[f].length;
            for (int j = 0; j < COL_SIZE; j++) {
                if (twoDimArray[f][j] > highest) {
                    highest = twoDimArray[f][j];
                }
            }
        }
        return highest;
    }

    /**
     * Looks for the lowest number in the row passed by calling function
     *
     * @param f sets the row to be searched
     * @return lowest in row
     */
    public double getLowestInRow(int f) {
        double lowest = twoDimArray[0][0]; // set to the first index and compare from there
        final int ROW_SIZE = twoDimArray.length;
        for (int i = 0; i < ROW_SIZE; i++) {
            final int COL_SIZE = twoDimArray[f].length;
            for (int j = 0; j < COL_SIZE; j++) {
                if (twoDimArray[f][j] < lowest) {
                    lowest = twoDimArray[f][j];
                }
            }
        }
        return lowest;
    }

    /**
     * this method calculated the highest value in the array
     *
     * @return max_value the highest value
     */
    public double getArrayMaxValue() {
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
     *
     * @return min_value the lowest value in the array
     */
    public double getArrayMinValue() {
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
     *
     * @return the standard deviation
     */
    public double calcStdDev() {
        double sum = 0.0, dev = 0.0, avg = 0.0;
        int counter = 0;
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                sum += twoDimArray[row][col];
                counter++;

            }
        }
        avg = sum / counter;
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                dev += Math.pow(twoDimArray[row][col] - avg, 2);

            }
        }
        return Math.sqrt(dev / counter);

    }

    /**
     * this method finds a number in the array
     *
     * @param check the value to serarch for
     * @return true or false if value is present
     */
    public boolean findValue(double check) {
        final int ROW_SIZE = twoDimArray.length;
        boolean test = false;
        for (int i = 0; i < ROW_SIZE; i++) {
            final int COL_SIZE = twoDimArray[i].length;
            for (int j = 0; j < COL_SIZE; j++) {
                if (twoDimArray[i][j] == check) {
                    test = true;
                }
            }
        }
        return test;
    }

    public boolean replace(double find, double replace) {

        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                if (twoDimArray[row][col] == find) {
                    twoDimArray[row][col] = replace;
                    return true;

                }
            }
        }

        return false;
    }

    public boolean replaceAll(double find, double replace) {
        boolean good = false;
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                if (twoDimArray[row][col] == find) {
                    twoDimArray[row][col] = replace;
                    good = true;
                }


            }
        }
        return good;
    }

    /**
     * gets the size of the row
     *
     * @return row
     */
    public int getRow() {
        int row = row_size;
        return row;
    }

    /**
     * gets the size of the column
     *
     * @return col
     */
    public int getCol() {
        int col = col_size;
        return col;
    }

}





