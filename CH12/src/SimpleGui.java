import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui {
    JLabel label;
    MyDrawPanel myPanel;

    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            myPanel.repaint();
        }
    }

    class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label.setText("label changed");
        }
    }

    public void go() {
        JButton colorButton = new JButton("change color");
        JButton labelButton = new JButton("change label");

        label = new JLabel("some cliche label");
        myPanel = new MyDrawPanel();

        JFrame frame = new JFrame("RASH");

        colorButton.addActionListener(new ColorListener());
        labelButton.addActionListener(new LabelListener());

        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, myPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }

}
