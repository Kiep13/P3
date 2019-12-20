package Handlers;

import Main.LPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;

public abstract class Handler extends MouseAdapter {

    protected static Color color;
    protected static Color colorFill;

    protected LPanel panel;
    protected int xStart, yStart, xEnd, yEnd;

    protected Graphics g;

    public Handler(LPanel panel) {
        this.panel = panel;
    }

    public static void setColorFill(Color choosedColor) {
        colorFill = choosedColor;
    }

    public static void setColor(Color choosedColor) {
        color = choosedColor;
    }



}
