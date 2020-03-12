import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat.", "One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think", "You might want to rethink that haircut."};

    public static void main(String[] args) {
        DailyAdviceServer d = new DailyAdviceServer();
        d.go();
    }

    void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while(true){
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getAdvice(){
        int randomIndex = (int)(Math.random() * adviceList.length);
        return adviceList[randomIndex];
    }
}
