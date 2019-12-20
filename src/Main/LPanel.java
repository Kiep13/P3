package Main;

import Handlers.*;

import javax.swing.*;
import java.awt.*;

public class LPanel extends JPanel {

    private Handler handler;

    public LPanel() {

        setHandler(this);

    }

    public void setHandler(LPanel panel) {

        setBackground(Color.white);
        //BrushHandler handler = new BrushHandler(panel);
        //RectHandler handler = new RectHandler(panel);
        //CircleHandler handler = new CircleHandler(panel);
        SpectrumHandler handler = new SpectrumHandler(panel);
        //LineHandler handler = new LineHandler(panel);

        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);

    }

}
