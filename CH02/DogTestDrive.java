public class DogTestDrive {
	public static void main(String[] args){
		Dog obj = new Dog();
		obj.name = "Husky";
		obj.age = 9;
		obj.breed = "Wolf kindof";
		obj.bark();;
		System.out.println("My dog's name is "+ obj.name + " .His age is "+obj.age+ " and he is a "+obj.breed);
	}
}
