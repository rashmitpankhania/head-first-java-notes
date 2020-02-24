import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Button1  implements ItemListener {
    JCheckBox checkBox = new JCheckBox("e check box");
    public static void main(String[] args) {
        Button1 button1 = new Button1();
        button1.go();
    }

    void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.CENTER, checkBox);
        checkBox.addItemListener(this);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        String on = "off";
        if(checkBox.isSelected()) on = "on";
        System.out.println("it is "+on);
    }
}
