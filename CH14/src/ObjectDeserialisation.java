import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectDeserialisation {
    public static void main(String[] args) {
        System.out.println("it started");
        try {
            FileInputStream f = new FileInputStream("/home/rashmit/Github/head-first-java-notes/my.pdf");
            ObjectInputStream os = new ObjectInputStream(f);

            ObjectSerialization n = (ObjectSerialization) os.readObject();
            os.close();
            System.out.println(n.name);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
