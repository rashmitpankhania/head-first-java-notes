public class MyAnimalList {
	Animal[] animals = new Animal[5]; // not instantiating the objects
// here we just created the array object to hold those kind of concrete objects

	private int currentIndex = 0;

	void add(Animal d){
		if(currentIndex < animals.length){
			animals[currentIndex] = d;
			System.out.println("Animal added at "+currentIndex);
			currentIndex++;
		}
	}
}