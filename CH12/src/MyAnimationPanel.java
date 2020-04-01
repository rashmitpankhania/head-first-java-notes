import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

public class MyAnimationPanel extends JPanel implements ControllerEventListener {
    boolean msg = false;

    @Override
    public void controlChange(ShortMessage shortMessage) {
        msg = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (msg) {
            Graphics2D graphics2D = (Graphics2D) g;

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);

            int ht = (int) ((Math.random() * 120) + 10);
            int width = (int) ((Math.random() * 120) + 10);
            int x = (int) ((Math.random() * 40) + (Math.random()*100));
            int y = (int) ((Math.random() * 40) + (Math.random()*100));
            g.setColor(new Color(red, green, blue));
            g.fillRect(x,y,ht, width);
            msg = false;
        }
    }
}

