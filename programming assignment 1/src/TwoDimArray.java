public class TwoDimArray {
    private double twoDimArray[][] = new double[6][6];
    private double total;
    private double avg;

    /**
     * iterates thrgouh the arrary and returns the total
     *
     * @param a
     * @return total
     */
    public double getTotal(double[][] a) {
        // loop through the array and add the values
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[col].length; col++) {
                total += a[row][col];
            }
        }
        return total;
    }

    /**
     * takes the avgerage of all the elements in the 2d array
     *
     * @param b array
     * @return avg
     */
    public double getAverage(double[][] b) {
        int sum = 0, count = 0;
        for (int row = 0; row < b.length; row++) {
            for (int col = 0; col < b[row].length; col++) {
                sum += b[row][col];
                count++; // accumulator


            }
        }
        avg = sum / count;
        return avg;
    }

    /**
     * @param c 2d array of double
     * @param d int for subscript of column
     * @return colTotal the total of the elements in a column
     */
    public double getColumnTotal(double[][] c, int d) {
        int colTotal = 0;
        for (int row = 0; row < c.length; row++) {
            for (int col = 0; col < c[row].length; col++) {
                colTotal += c[row][d]; // loop through the row but only look at the subscript for the column passed to the method

            }
        }
        return colTotal;

    }

    /**
     * find the highest value in the row
     *
     * @param e array of doubles
     * @param f int for subscript
     * @return the lowest value in the row
     */
    public double getHighestInRow(double[][] e, int f) {
        for (int i = f; i < e[i].length; ) {
            for (int j = 0; j < e[i].length; j++) {
                holder = e[i][j];
                if (e[i][j] > e[i][j]) {
                    holder = e[i][j];
                }
            }
        }
        return holder;

    }

    /**
     * find the lowest value in the row
     *
     * @param g array of doublw
     * @param h int for supcript to search
     * @return lowest value
     */
    public double getLowestInRow(double[][] g, int h) {
        for (int i = f; i < e[i].length; ) {
            for (int j = 0; j < e[i].length; j++) {
                holder = e[i][j];
                if (e[i][j] < e[i][j]) {
                    holder = e[i][j];
                }
            }
        }
        return holder;

    }

    public double getArrayMaxValue() {
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                holder = twoDimArray[row][col];
                if (twoDimArray[row][col] > twoDimArray[row][col]) {
                    holder = twoDimArray[row][col];
                }

            }
        }
        return holder;

    }

    public double getArrayMinValue() {
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                holder = twoDimArray[row][col];
                if (twoDimArray[row][col] < twoDimArray[row][col]) {
                    holder = twoDimArray[row][col];
                }

            }
        }
        return holder;

    }

    public double calcStdDev() {
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

    public double findValue(double) {

    }

    public double replace(double) {

    }

    public double replaceAll(double) {

    }

    public void loadArray() {

    }
}
