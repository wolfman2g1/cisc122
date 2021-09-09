import java.util.Scanner;

public class Average {
	private int[] data;
	private double mean;

	public Average() {
		final String MSG = "Please enter a score";
		data = new int[5];
		// to account for 0 vs 1 we set i to 1
		for (int i = 1; i < 5; i++) {
			System.out.println(MSG + " " + i);
			Scanner sc = new Scanner(System.in);
			int score = sc.nextInt();
			data[i] = score;
		}
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
		return null;
	}

}
