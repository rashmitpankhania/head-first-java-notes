import javax.swing.*;
import java.awt.*;

public class ShrinkingRectangle {
    static int x = 1;
    static int y = 1;

    public static void main(String[] args) {
        ShrinkingRectangle shrinkingRectangle = new ShrinkingRectangle();
        shrinkingRectangle.go();
    }

    public void go(){
        JFrame frame = new JFrame("Rash");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 270);
        ShrinkingRecPanel shrinkingRecPanel = new ShrinkingRecPanel();
        frame.getContentPane().add(shrinkingRecPanel);
        frame.setVisible(true);
        for (int i=0;i<124;i++,x++,y++){
            x++;
            shrinkingRecPanel.repaint();
            try {
                Thread.sleep(50);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ShrinkingRecPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0,0,500,250);
            g.setColor(Color.blue);
            g.fillRect(x,y, 500-x*2, 250 - y*2);
        }
    }
}
