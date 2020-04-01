public class BeerSong{
	public static void main(String[] args){
		int num = 99;
		String s = "bottles";
		while(num > 0){
			System.out.println(String.format("%d %s of beer on the wall, %d %s of beer.",num, s, num, s));
			num--;
			if(num == 0)
				break;
			if(num == 1)
				s = "bottle";
			System.out.println(String.format("Take one down and pass it around, %d %s of beer on the wall.\n", num, s));
		}
		System.out.println("Take one down and pass it around, no more bottles of beer on the wall.\n\nNo more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.");
	}
}
