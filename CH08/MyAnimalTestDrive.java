public class MyAnimalTestDrive {
	public static void main(String[] args) {
		MyAnimalList m = new MyAnimalList();

		Dog marcus = new Dog();
		Cat kathy = new Cat();

		m.add(marcus);
		m.add(kathy);
		System.out.println(m.animals[1].getClass());
	}
}