import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button1 implements ActionListener {
    JTextArea textArea = new JTextArea(10,20);

    public static void main(String[] args) {
        Button1 button1 = new Button1();
        button1.go();
    }

    void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        panel.setBackground(Color.yellow);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scrollPane);

        JButton button = new JButton("Click");
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        button.addActionListener(this);


        frame.setSize(300,300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        textArea.append("Button clicked \n");
    }
}
