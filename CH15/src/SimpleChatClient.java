import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClient {
    JTextField textField;
    Socket socket;
    PrintWriter writer;

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }

    void go(){
        JFrame frame = new JFrame("Hell simple chat client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        textField = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendListener());
        panel.add(textField);
        panel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        setupNetworking();

        frame.setSize(400, 600);
        frame.setVisible(true);
    }

    void setupNetworking(){
        try {
            socket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(socket.getOutputStream());
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
}
