import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
    public static void main(String[] args) {
        go();
    }

    private static void go() {
        try {
            Socket s = new Socket("127.0.0.1", 4242);
            InputStreamReader i = new InputStreamReader(s.getInputStream());
            BufferedReader b = new BufferedReader(i);
            System.out.println(b.readLine());
            b.close();
            while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
