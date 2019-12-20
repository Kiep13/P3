package Handlers;

import Main.LPanel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CircleHandler extends Handler {

    int width, height;

    public CircleHandler(LPanel panel) {
        super(panel);
    }

    public void mousePressed(MouseEvent e) {
        xStart = e.getX();
        yStart = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        xEnd = e.getX();
        yEnd = e.getY();

        g = panel.getGraphics();

        g.setColor(color);

        width = xEnd - xStart;
        height = yEnd - yStart;
        g.fillOval(xStart, yStart, width, height);

        g.setColor(colorFill);
        width -= (2*lineWidth);
        height -= (2*lineWidth);
        g.fillOval(xStart + lineWidth, yStart + lineWidth, width, height);
    }

}
