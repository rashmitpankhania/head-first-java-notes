import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {

    static Color getRandomColor() {
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
//
        return new Color(red, green, blue);
    }

    @Override
    public void paintComponent(Graphics g) {
        // it create the rectangle
//        g.setColor(Color.ORANGE);
//        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // it adds the image to the panel and yes use absolute path
//        Image image = new ImageIcon("/home/rashmit/Github/head-first-java-notes/CH12/src/sample.jpg").getImage();
//        g.drawImage(image, 3,4,this);

        // it creates a random circle
//        int red = (int) (Math.random() * 255);
//        int green = (int) (Math.random() * 255);
//        int blue = (int) (Math.random() * 255);
//
//        Color color = new Color(red, green, blue);
//        g.setColor(color);
//        g.fillOval(70, 70, 100, 100);

        Graphics2D graphics2D = (Graphics2D) g;
        GradientPaint gradientPaint = new GradientPaint(70, 70, MyDrawPanel.getRandomColor(), 100, 100, MyDrawPanel.getRandomColor());

        graphics2D.setPaint(gradientPaint);
        graphics2D.fillOval(50, 50, 100, 100);
    }
}
