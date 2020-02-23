import javax.swing.*;
import java.awt.*;

public class Button1 {
    public static void main(String[] args) {
        Button1 button1 = new Button1();
        button1.go();
    }

    void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        frame.getContentPane().add(BorderLayout.EAST, panel);
        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JButton button = new JButton("shock me");
        JButton buttonTwo = new JButton("bliss");
        JButton buttonThree = new JButton("huh?");
        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonThree);
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JTextField("name likh bhsodik"));
        centerPanel.setBackground(Color.cyan);
        frame.getContentPane().add(BorderLayout.CENTER, centerPanel);

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
