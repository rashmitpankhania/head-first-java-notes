import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class MusicSystemServer {
    ArrayList<ObjectOutputStream> clientOutputStreams;


    class ClientHandler implements Runnable {
        ObjectInputStream in;
        Socket client;

        @Override
        public void run() {
            Object stringObj;
            Object boolArrObj;

            try {
                while ((stringObj = in.readObject()) != null) {
                    boolArrObj = in.readObject();
                    System.out.println("read two objects");
                    tellEveryOne(stringObj, boolArrObj);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public ClientHandler(Socket clientSocket) {
            client = clientSocket;
            try {
                in = new ObjectInputStream(clientSocket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MusicSystemServer().go();
    }

    void go() {
        clientOutputStreams = new ArrayList<>();
        try {
            while (true) {
                ServerSocket serverSocket = new ServerSocket(4242);
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientOutputStreams.add(new ObjectOutputStream(clientSocket.getOutputStream()));
                clientThread.start();
                System.out.println(" got a connection");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void tellEveryOne(Object s, Object b) {
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            ObjectOutputStream out = (ObjectOutputStream) it.next();
            try {
                out.writeObject(s);
                out.writeObject(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
