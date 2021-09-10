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
		Song[] cd = new Song[6];

		for (int i = 0; i < cd.length; i++) {

			title = input.readLine();
			artist = input.readLine();
			Song music = new Song(title, artist);
			cd[i] = music;

		}

		System.out.println("Contents of Classics:");
		for (int i = 0; i < cd.length; i++) {
			System.out.println(cd[i]);

		}
	}
}
