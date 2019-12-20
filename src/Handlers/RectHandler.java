package Handlers;

import Main.LPanel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class RectHandler extends Handler {

    int width, height;

    public RectHandler(LPanel panel) {
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
        g.fillRect(xStart, yStart, xEnd - xStart, yEnd - yStart);

        g.setColor(colorFill);
        width -= (2*lineWidth);
        height -= (2*lineWidth);
        g.fillRect(xStart + lineWidth, yStart + lineWidth, width, height);
    }

}