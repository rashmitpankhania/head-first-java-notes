import java.io.*;

public class ObjectSerialization implements Serializable {
    String name;

    public static void main(String[] args) {
        ObjectSerialization obj = new ObjectSerialization();
        obj.name = "Rashmit";
        try {
            FileOutputStream fs = new FileOutputStream("my.pdf");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(obj);
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println("file nai mila");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ye kuch or ha");
        }
        System.out.println(obj.name);
    }
}
