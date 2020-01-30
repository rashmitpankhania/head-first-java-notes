import java.util.ArrayList;

public class DotGame {
	private ArrayList<String> locationCells;
	private String name;
	
	String checkYourself(String userInput){ 
		String result = "miss";

		for(String cell: locationCells){
			int index = locationCells.indexOf(userInput);
			if(index >= 0){
				locationCells.remove(index);
				if(locationCells.isEmpty())
					result = "kill";
				else
					result = "hit";
			}
		}
		
		System.out.println(result);
		
		return result;
	}

	void setLocationCells(ArrayList<String> l){
		locationCells = l;
	}

	void setName(String i){
		name = i;
	}
}
