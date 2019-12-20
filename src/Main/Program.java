package Main;

import javax.swing.*;
import java.awt.*;

public class Program {

    public static void main(String [] args) {

        new Program();

    }

    public Program () {

        JFrame frame = new JFrame("Painter");
        frame.setSize(300, 500);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dimension.width/2 - 150, dimension.height/2 - 250);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        frame.setLayout(layout);

        GridBagConstraints c =  new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.fill   = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;

        LPanel panel = new LPanel();
        frame.getContentPane().add(panel, c);
        frame.revalidate();
        frame.repaint();

    }

}
