public class PhraseOMatic {
	public static void main(String[] args){
		String[] wordListThree = {"Grapes", "Tuna", "Subway", "Subway Surfers", "Ramen Noodles", "Slime", "Fidget Spinner", "Dolphin", "Sugar Cube, Sugar Cube, Sugar Cube", "Rubiks Cube", "iPod Touch", "Chromebook", "Pugsly", "The Magic School Bus", "Snickerdoodles", "Ebola", "Washington Monument", "MusiLy", "Spotify", "Snowboarding or Skiing", "Boy Meets World", "Boo", "Boog", "Boots", "Full House"};
		String[] wordListOne = {"24/7","multi-Tier","30,000 foot","B-to-B","win-win","front-end", "web-based","pervasive", "smart", "six-sigma","critical-path", "dynamic"};
		String[] wordListTwo = {"pedal", "stain", "wipe", "attend", "shave", "tease", "camp", "reproduce", "turn", "juggle", "fire", "instruct", "improve", "pour", "box", "blush", "smoke", "peel", "invite", "clear", "develop", "consider", "sneeze", "reduce", "listen", "tremble", "dress", "park", "add", "possess"};
		
		// lengths of the list
		int listOneLength = wordListOne.length;
		int listTwoLength = wordListTwo.length;
		int listThreeLength = wordListThree.length;

		// generating the three random numbers
		int r1 = (int)(Math.random()*listOneLength);
		int r2 = (int)(Math.random()*listTwoLength);
		int r3 = (int)(Math.random()*listThreeLength);

		String phrase = String.format("%s %s %s.", wordListThree[r3], wordListTwo[r2], wordListOne[r1]);
		System.out.println(phrase);
	}
}
