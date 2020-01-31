import java.util.ArrayList;

public class DotGameBust {
	private ArrayList<DotGame> dotComList = new ArrayList<DotGame>();
	private GameHelper helper = new GameHelper();
	int numOfGuesses;

	private void setUpGame() {
		DotGame obj1 = new DotGame();
		DotGame obj2 = new DotGame();
		DotGame obj3 = new DotGame();

		obj1.setName("Facebook");
		obj2.setName("Google");
		obj3.setName("Airbnb");

		dotComList.add(obj1);
		dotComList.add(obj2);
		dotComList.add(obj3);

		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Facebook.com, Google.com, Airbnb.com");
		System.out.println("Try to sink them all in the fewest number of guesses");

		for (DotGame d : dotComList) {
			ArrayList<String> locationList = helper.placeDotCom(3);
			d.setLocationCells(locationList);
		}
	}

	private void startPlaying() {
		while (!dotComList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess!");
			numOfGuesses++;
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	private void checkUserGuess(String userGuess) {
		String res = "miss";
		for (DotGame d : dotComList) {
			res = d.checkYourself(userGuess);
			if (res.equals("kill")) {
				System.out.println("You have killed the " + d.getName());
				dotComList.remove(d);
				break;
			} else if (res.equals("hit")) {
				break;
			}
		}
		System.out.println(res);
	}

	private void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println(" You got out before your options sank.");
		} else {
			System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}

	public static void main(String[] args) {
		DotGameBust d = new DotGameBust();
		d.setUpGame();
		d.startPlaying();
	}
}