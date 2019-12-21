package Main;

import Handlers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LPanel extends JPanel {

    public static BufferedImage paint;

    public Graphics g;
    private Handler handler;
    private JLabel label;

    public LPanel() {

        paint = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        label = new JLabel();
        label.setLocation(0,0);
        setStartSettings(this);

    }

    public void setStartSettings(LPanel panel) {

        setBackground(Color.white);
        handler = new BrushHandler(panel);

        Handler.setColor(Color.BLACK);
        Handler.setColorFill(Color.WHITE);
        Handler.setLineWidth(1);

        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
    }

    public void setHandler(LPanel panel, String text) {

        this.removeMouseListener(handler);
        this.removeMouseMotionListener(handler);

        switch(text) {

            case "Кисть" : handler = new BrushHandler(panel); break;
            case "Линия" : handler = new LineHandler(panel); break;
            case "Прямоугольник" : handler = new RectHandler(panel); break;
            case "Овал" : handler = new CircleHandler(panel); break;
            case "Спектр" : handler = new SpectrumHandler(panel);

        }

        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);

    }

    public void setColor(Color color) {
        Handler.setColor(color);
    }

    public void setColorFill(Color colorFill) {
        Handler.setColorFill(colorFill);
    }

    public void setLineWidth(int value) {
        Handler.setLineWidth(value);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (paint != null) {
            g.drawImage(paint, 0, 0, paint.getWidth(), paint.getHeight(), null);
        }
    }

    public static void createImage(LPanel panel) {
        Point p = new Point(0, 0);
        SwingUtilities.convertPointToScreen(p, panel);

        //Get the region with wiht and heighht of panel and
        // starting coordinates of p.x and p.y
        Rectangle region = panel.getBounds();
        region.x = p.x;
        region.y = p.y;

        //Get screen capture over the area of region
        paint = null;
        try {
            paint = new Robot().createScreenCapture( region );
        } catch (AWTException ex) {
            Logger.getLogger(LPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void getScreenShot(JPanel panel) throws IOException {
        paint = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        panel.paint(paint.getGraphics());
        Graphics2D g2 = paint.createGraphics();
        g2.drawImage(paint, null, null);

        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(paint)));
    }

}
