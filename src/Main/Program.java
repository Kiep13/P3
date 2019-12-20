package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Program {

    private LPanel panel;


    public static void main(String [] args) {

        new Program();

    }

    public Program () {

        JFrame frame = new JFrame("Painter");
        frame.setSize(500, 500);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dimension.width/2 - 250, dimension.height/2 - 250);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("paintbrush.png");
        frame.setIconImage(icon.getImage());

        GridBagLayout layout = new GridBagLayout();
        frame.setLayout(layout);

        GridBagConstraints c =  new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.fill   = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;

        panel = new LPanel();
        frame.getContentPane().add(panel, c);

        JMenuBar menu = new JMenuBar();

        menu.add(createFigureMenu());
        menu.add(createLineMenu());
        menu.add(createColorMenu());
        menu.add(createFillColorMenu());

        menu.setBackground(Color.white);

        frame.setJMenuBar(menu);

        frame.revalidate();
        frame.repaint();

        frame.addComponentListener(new ComponentAdapter() {

            public void componentResized(ComponentEvent e) {

            }

            public void componentMoved(ComponentEvent e) {

            }

        });

    }

    public JMenu createFigureMenu() {

        JMenu figureMenu = new JMenu("Фигура");

        JRadioButtonMenuItem brush = new JRadioButtonMenuItem("Кисть");
        JRadioButtonMenuItem line = new JRadioButtonMenuItem("Линия");
        JRadioButtonMenuItem rect = new JRadioButtonMenuItem("Прямоугольник");
        JRadioButtonMenuItem oval = new JRadioButtonMenuItem("Овал");
        JRadioButtonMenuItem spect = new JRadioButtonMenuItem("Спектр");


        brush.setSelected(true);

        class RadioButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = (((JRadioButtonMenuItem)e.getSource()).getText());
                panel.setHandler(panel, text);
            }
        }

        RadioButtonListener listener = new RadioButtonListener();
        brush.addActionListener(listener);
        line.addActionListener(listener);
        rect.addActionListener(listener);
        oval.addActionListener(listener);
        spect.addActionListener(listener);


        ButtonGroup bg = new ButtonGroup();
        bg.add(brush);
        bg.add(line);
        bg.add(rect);
        bg.add(oval);
        bg.add(spect);

        figureMenu.add(brush);
        figureMenu.add(line);
        figureMenu.add(rect);
        figureMenu.add(oval);
        figureMenu.add(spect);

        return figureMenu;

    }

    public JMenu createLineMenu() {

        JMenu lineMenu = new JMenu("Линия");

        JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 1, 15, 1);

        JLabel currentSize = new JLabel(" 1");
        currentSize.setOpaque(false);

        slider.addChangeListener(arg0 -> {
            int value = slider.getValue();
            panel.setLineWidth(value);
            currentSize.setText(String.valueOf(value));
        });




        lineMenu.add(slider);
        lineMenu.add(currentSize);

        return lineMenu;

    }

    public JMenu createColorMenu() {

        JMenu colorMenu = new JMenu("Цвет");

        final JColorChooser chooser = new JColorChooser();

        chooser.getSelectionModel().addChangeListener(arg0 -> {
            Color color = chooser.getColor();
            System.out.print(color);
            panel.setColor(color);
        });

        colorMenu.add(chooser);

        return colorMenu;

    }

    public JMenu createFillColorMenu() {

        JMenu fillColorMenu = new JMenu("Цвет заливки");

        final JColorChooser chooser = new JColorChooser();

        chooser.getSelectionModel().addChangeListener(arg0 -> {
            Color color = chooser.getColor();
            panel.setColorFill(color);
        });

        fillColorMenu.add(chooser);

        return fillColorMenu;

    }

}
