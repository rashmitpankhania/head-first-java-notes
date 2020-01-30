public class SimpleDotGameTestDrive {
	public static void main(String[] args){
		SimpleDot d = new SimpleDot();
		int[] locationCells = {2, 3, 7};
		d.setLocationCells(locationCells);
		String userInput = "2";
		String result = d.checkYourself(userInput);
		if(result == "hit")
			System.out.println("passed");
		else
			System.out.println("failed");

