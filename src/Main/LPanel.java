package Main;

import Handlers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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

        Rectangle region = panel.getBounds();
        region.x = p.x;
        region.y = p.y;

        paint = null;
        try {
            paint = new Robot().createScreenCapture( region );
        } catch (AWTException ex) {
            Logger.getLogger(LPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clean() {

        Graphics g = this.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        createImage(this);

    }

}
