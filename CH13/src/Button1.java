import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Button1 implements ListSelectionListener {
    String[] data = {"Register", "an", "ActionListener", "for", "each", "of", "the", "four", "buttons.", "We", "don’t", "", "", "", "", "need", "listeners", "for", "the", "individual", "checkboxes,", "because", "we", "aren’t", "", "", "", "", "trying", "to", "change", "the", "pattern", "sound", "dynamically", "(i.e.", "as", "soon", "as", "the", "", "", "", "", "", "", "", "", "", "", "", "", "user", "checks", "a", "box).", "Instead,", "we", "wait", "until", "the", "user", "hits", "the", "‘start’", "", "", "", "", "button,", "and", "then", "walk", "through", "all", "256", "checkboxes", "to", "get", "their", "state", "", "", "", "", "and", "make", "a", "MIDI", "track."};
    JList<String> list = new JList<>(data);

    public static void main(String[] args) {
        Button1 button1 = new Button1();
        button1.go();
    }

    void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        list.addListSelectionListener(this);
        list.setVisibleRowCount(10);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if(!listSelectionEvent.getValueIsAdjusting()){
            String selection = list.getSelectedValue();
            System.out.println(selection);
        }
    }
}
