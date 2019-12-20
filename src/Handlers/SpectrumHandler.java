package Handlers;

import Main.LPanel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SpectrumHandler extends Handler {

    int xHelp, yHelp;

    public SpectrumHandler(LPanel panel) {
        super(panel);
    }

    public void mousePressed(MouseEvent e) {
        xStart = e.getX();
        yStart = e.getY();

        xHelp = this.xStart;
        yHelp = this.yStart;
    }

    public void mouseDragged(MouseEvent e) {
        xEnd = e.getX();
        yEnd = e.getY();

        g = panel.getGraphics();
        g.setColor(color);
        ((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
        g.drawLine(xStart, yStart, xEnd, yEnd);
        g.drawLine(xEnd, yEnd, xHelp, yHelp);

        xHelp = xEnd;
        yHelp = yEnd;
    }

}
