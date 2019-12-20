package Handlers;

import Main.LPanel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LineHandler extends Handler {

    public LineHandler(LPanel panel) {
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
        ((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
        g.drawLine(xStart, yStart, xEnd, yEnd);
    }

}
