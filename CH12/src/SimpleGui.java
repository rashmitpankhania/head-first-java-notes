import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SimpleGui implements ActionListener, ItemListener {
    JButton button;
    MyDrawPanel mypanel;

    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }

    public void go() {
        button = new JButton("click kar");
        mypanel = new MyDrawPanel();
        mypanel.add(button);
        JFrame frame = new JFrame();
        button.addActionListener(this);
        button.addItemListener(this);
        frame.getContentPane().add(mypanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        button.setText("i m pressed");
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        button.setText("helo");
    }
}
