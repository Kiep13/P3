package Handlers;

import Main.LPanel;
import java.awt.event.MouseEvent;

public class CircleHandler extends Handler {

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
        g.fillOval(xStart, yStart, xEnd - xStart, yEnd - yStart);
    }

}
