public class Player {
	String name = "Player";
	int num = 0;

	void guess(){
		this.num = (int)(Math.random()*10);
		System.out.println("Player "+this.name+ " has guessed the numeber "+this.num+".");
	}

	Player(String iName){
		this.name = iName;
	}
}
