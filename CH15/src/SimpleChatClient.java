import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClient {
    JTextArea incoming;
    JTextField textField;
    Socket socket;
    PrintWriter writer;
    BufferedReader reader;

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }

    void go(){
        JFrame frame = new JFrame("Hell simple chat client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        incoming = new JTextArea(15,50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        textField = new JTextField(20);

        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendListener());
        panel.add(qScroller);
        panel.add(textField);
        panel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        setupNetworking();

        Thread incomingThread = new Thread(new IncomingThread());
        incomingThread.start();

        frame.setSize(400, 600);
        frame.setVisible(true);
    }

    void setupNetworking(){
        try {
            socket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("networking done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class SendListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            writer.println(textField.getText());
            writer.flush();
            textField.setText("");
            textField.requestFocus();
        }
    }

    class IncomingThread implements Runnable{

        @Override
        public void run() {
            String message;
            try{
                while((message = reader.readLine()) != null){
                    System.out.println("received - "+message);
                    incoming.append(message);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
