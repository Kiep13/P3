package Handlers;

import Main.LPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;

public abstract class Handler extends MouseAdapter {

    protected LPanel panel;
    protected int xStart, yStart, xEnd, yEnd;
    protected Graphics g;

    public Handler(LPanel panel) {
        this.panel = panel;
    }
}
