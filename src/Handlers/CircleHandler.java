package Handlers;

import Main.LPanel;

import java.awt.event.MouseEvent;

public class CircleHandler extends Handler {

    private int width, height;

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

        width = Math.abs(xEnd - xStart);
        height = Math.abs(yEnd - yStart);

        xStart = Math.min(xStart, xEnd);
        yStart = Math.min(yStart, yEnd);

        g.fillOval(xStart, yStart, width, height);

        g.setColor(colorFill);
        width -= (2*lineWidth);
        height -= (2*lineWidth);
        g.fillOval(xStart + lineWidth, yStart + lineWidth, width, height);
    }

}
