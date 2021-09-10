import java.io.*;
import java.util.ArrayList;

/**
 * This program creates a list of songs for a CD by reading from a file.
 */
public class CompactDisc {
	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("src/Classics.txt"); // need to change the realtive path based on your setup
		BufferedReader input = new BufferedReader(file);
		String title;
		String artist;
		// ADD LINES FOR TASK #3 HERE
		// Declare an array of Song objects, called cd,
		// with a size of 6
		String cd[] = new String[6];

		for (int i = 0; i < cd.length; i++) {
			while (input.readLine() != null) {
				title = input.readLine();
				cd[i] = title;
				artist = input.readLine();
				cd[i + 1] = artist;
				System.out.println(cd[i] + " " + cd[i + 1]);
			}

			// ADD LINES FOR TASK #3 HERE // Fill the array by creating a new song with //
			// the title and artist and storing it in the // appropriate position in the
			// array

		}

		System.out.println("Contents of Classics:");
		for (int i = 0; i <= cd.length; i++) {
			

		}
	}
}
