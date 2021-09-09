package pet;

class Pet {
	private String name;
	private String animal;
	private int age;

	public Pet() {

	}

	public Pet(String n, String t, int a) {
		name = n;
		animal = t;
		age = a;
	}

	public void setName(String n) {
		name = n;

	}

	public void setAnimal(String a) {
		animal = a;

	}

	public void setAge(int a) {
		age = a;

	}

	public String getName() {

		return name;
	}

	public String getAnimal() {
		return animal;
	}

	public int getAge() {
		return age;

	}
	public String toString() {
		return name + " " + animal + " " + age;
	}
}
