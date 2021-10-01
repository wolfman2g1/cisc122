package exception;

public class DTest {
	public static void main(String[] args) {
		int x = 10;
		int y = 0;
		try {
			System.out.println(x / y);
		} catch (Exception e) {
			System.out.println("division by zero");

		}
	}
}
