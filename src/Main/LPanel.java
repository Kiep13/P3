package Main;

import Handlers.*;

import javax.swing.*;
import java.awt.*;

public class LPanel extends JPanel {

    private Handler handler;

    public LPanel() {

        setStartSettings(this);

    }

    public void setStartSettings(LPanel panel) {

        setBackground(Color.white);
        BrushHandler handler = new BrushHandler(panel);

        handler.setColor(Color.BLACK);
        handler.setColorFill(Color.WHITE);

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
        System.out.print(color);
        handler.setColor(color);
    }

    public void setColorFill(Color colorFill) {
        handler.setColorFill(colorFill);
    }

}
