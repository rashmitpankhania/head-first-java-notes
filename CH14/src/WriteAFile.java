import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("my.txt");
            fw.write("kesa h mad");
            fw.close();
        } catch (IOException e){
            System.out.println("file nai mila shyd");
        }
    }
}
