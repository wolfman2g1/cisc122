import java.util.*;
import java.io.*;
public class IntSearch {
	public static void main(String[] args) throws IOException{
		int[] data = new int[15];
		Scanner inFile;
		int target = -1;
		if (args.length == 0) {
			
			System.out.println(" no filename entered");
			System.exit(1);
		}
		File f = new File(args[0]);
		if (!f.exists()) {
			System.out.println(" File not found" + args[0]);
			System.exit(2);
		}
		inFile = new Scanner(f);
		int i =0;
		while(inFile.hasNext() && i < data.length) {
			try {
				data[i] = inFile.nextInt();
			}
			catch (Exception e) {
				data[i] =0;
			}
			++i;
		}
		target = 5999;
		if (search(data,target) == -1) {
			System.out.println("Target not found " + target);
			
		}
		else {
			System.out.println("Target found" + target);
		}
	}

	public static int search(int[] d, int t) {
		for (int k= 0; k < d.length; k++) {
			if (d[k] == t) {
				return k;
			}
			
		}
		return -1;
	}
}
