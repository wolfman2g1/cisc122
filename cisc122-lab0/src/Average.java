import java.util.Scanner;
/**
 * 
 * @author rjones
 * 09-10-2021
 * Takes input from the user and performs mathematical operations on the input
 *
 */


public class Average {
	private int[] data;
	private double mean;
/*
 * 
 */
	public Average() {
		final String MSG = "Please enter a score";
		data = new int[5];
		Scanner sc = new Scanner(System.in);
		// to account for 0 vs 1 we set i to 1
		for (int i = 1; i < 5; i++) {
			System.out.println(MSG + " " + i);
			
			int score = sc.nextInt();
			data[i] = score;
		}
		sc.close();
		calculateMean();
		selectionSort();

	}
	public void selectionSort() {
		int minIndex, minValue, start;
		int r = data.length; // this is so we don't have to keep looking up the array length
		for ( start = 0; start < r; start++) {
			minIndex = start;
			minValue = data[start];
			for (int index = start + 1; index < r; index++ ) {
				if (data[index] < minValue) {
					minValue = data[index];
					minIndex = index;
				}
			}
			data[minIndex] = data[start];
			data[start] = minValue;
			
		}
	}
	public void calculateMean() {
		int temp = 0;
		int n = data.length;
		for (int j=0; j<5; j++) {
			
			 temp += data[j];
		}
		 mean = temp/n;
		
	}
	public String toString() {
		int l = data.length;
		String order = " ";
		for (int i=l-1; i >0; i--) {
			order += data[i] + " " + "Mean" + " " +  mean;
		}
		return order;
		
	}

}
