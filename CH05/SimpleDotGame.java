public class SimpleDotGame {
	private int[] locationCells;
	int numOfHits;

	String checkYourself(String userInput){
		int guess = Integer.parseInt(userInput); 
		String result = "miss";

		for(int cell: locationCells){
			if(cell == guess){
				numOfHits++;
				result = "hit";
				break;
			}
		}
		
		if(numOfHits == locationCells.length)
			result = "kill";
		System.out.println(result);
		
		return result;
	}

	void setLocationCells(int[] l){
		locationCells = l;
	}
}
