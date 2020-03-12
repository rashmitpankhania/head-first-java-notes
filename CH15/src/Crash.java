import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class Crash {
    public static void main(String[] args) {
        try {
            Socket chatSocket = new Socket("127.0.0.1", 5000);
            InputStreamReader i = new InputStreamReader(chatSocket.getInputStream());
            BufferedReader b = new BufferedReader(i);
            String m = b.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}