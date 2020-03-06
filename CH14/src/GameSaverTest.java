import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(30, "Elf", new String[]{"bow", "arrow"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[]{"spells", "invisibility"});

        try {
            FileOutputStream fo = new FileOutputStream("my.pdf");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(one);
            oo.writeObject(two);
            oo.writeObject(three);
            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            FileInputStream fi = new FileInputStream("/home/rashmit/Github/head-first-java-notes/my.pdf");
            ObjectInputStream oi = new ObjectInputStream(fi);
            two = (GameCharacter) oi.readObject();
            one = (GameCharacter) oi.readObject();
            three = (GameCharacter) oi.readObject();
            GameCharacter four = (GameCharacter) oi.readObject();

            System.out.println(one.getType() + " " + two.getType() + " " + three.getType() + " " + four.getType());
        } catch (EOFException e) {
            System.out.println("cat");
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert three != null;
            System.out.println(one.getType() + " " + two.getType() + " " + three.getType());
        }

    }
}
