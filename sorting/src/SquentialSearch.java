
public class SquentialSearch {
	public static void main(String[] args) {
		int[] a = { 200, 1, 21, 24, 13, 35, 25, 56, 5, 76, 78, 9, 98, 10, 101, 19 };
		int value = 5;
		int result = -1;

		result = search(a, value);
		if (result != -1) {
			System.out.println(value + "found at indexL" + result);

		} else {
			System.out.println(value + "  not found");
		}
		IntInsertionSorter.insertionSortDES(a);
		System.out.println("\nSorted order:");
		for (int element : a)
			System.out.println(element + " ");
		System.out.println();
		result = -1;
		result -= search(a, value);
		if (result != -1) {
			System.out.println(value + " found at index" + result);
		} else {
			System.out.println(value + "not found");
		}

	}

	public static int search(int a[], int item) {
		int position = -1;
		boolean found = false;
		int index =0;
		long startTime = System.currentTimeMillis();
		while (!found && index < a.length) {
			if (a[index] == item) {
				found = true;
				position = index;
			}
			index++;
		}
	for(

	long j = 0;j<100000000;j++)
	{
	}
	long stopTime = System
			.currentTimeMillis();System.out.println(" Search Execution Time for"+item + ";"+(stopTime-startTime)+"ms");return position;
}

}
