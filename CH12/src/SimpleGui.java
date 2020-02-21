import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui {
    JLabel label;
    MyDrawPanel myPanel;
    AnimationPanel myAnimationPanel;

    static class AnimationPanel extends JPanel{
        int x=20;
        int y=20;
        @Override
        protected void paintComponent(Graphics g) {

            g.fillRect(0,0,this.getWidth(), this.getHeight());

            g.setColor(Color.ORANGE);
            g.fillOval(x, y, 100, 100);
        }
    }

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
        myAnimationPanel = new AnimationPanel();

        JFrame frame = new JFrame("RASH");

        colorButton.addActionListener(new ColorListener());
        labelButton.addActionListener(new LabelListener());

        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, myAnimationPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);

        for(int i=0;i<500;i++){
            myAnimationPanel.x++;
            myAnimationPanel.y++;
            myAnimationPanel.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }

}
