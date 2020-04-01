import java.io.*;

public class ReadAFile {
    public static void main(String[] args) {
        File myFile = new File("/home/rashmit/Desktop/ques");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile));
            String l = null;
            while((l = bufferedReader.readLine()) != null){
                System.out.println(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
