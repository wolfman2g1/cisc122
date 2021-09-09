package pet;

public class PetTest1 {
	public static void main(String[] args) {
		PetTest1 pt = new PetTest1();
		pt.run();
		new PetTest1().execute();

	}
	public void run() {
		Pet p1 = new Pet();
	}
	public void execute() {
		Pet p3 = new Pet("goldie", "fish", 2);
		System.out.println( p3.toString());
	}
}
