public class Game{
	Player p1;
	Player p2;
	Player p3;
	int num;

	void startgame(){
		p1 = new Player("Rose");
		p2 = new Player("Helen");
		p3 = new Player("Joseph");
		this.num = (int)(Math.random()*10);
		System.out.println("So the game number is "+this.num+" .");

		p1.guess();
		p2.guess();
		p3.guess();

		if(p1.num == this.num)
			System.out.println(p1.name+" wins!!");
		if(p2.num == this.num)
			System.out.println(p2.name+" wins!!");	
		if(p3.num == this.num)
			System.out.println(p3.name+" wins!!");;
	}
}
