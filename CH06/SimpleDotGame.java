public class SimpleDotGame {
	private int[] locationCells;
	int numOfHits;

	public static void main(String[] args){
		int numOfGuesses = 0;
		int startingCell = (int)(Math.random()*5);
		int[] cells = {startingCell+2,startingCell+1,startingCell};
		SimpleDotGame s = new SimpleDotGame();
		s.setLocationCells(cells);

		while(true){
			String userInput = GameHelper.getUserInput("Enter a number:");
			numOfGuesses++;
			String result = s.checkYourself(userInput);
			if(result == "kill")
				break;
		}
		System.out.println("Your gueses are "+numOfGuesses);
	}

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
