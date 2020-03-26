package geoshapes;

import javax.swing.*;

import java.awt.*;

public class Toolbar extends JPanel {
    private Integer[] sidesNo = { 0, 3, 4, 5, 6, 7, 8 };

    JLabel shapeNoLabel = new JLabel("Shapes number: ");
    JLabel strokeLabel = new JLabel("Stroke size: ");
    JLabel sideLabel = new JLabel("Sides no:");

    JTextField shapesNo = new JFormattedTextField();
    JTextField shapesStroke = new JFormattedTextField();
    JComboBox sidesNoValue = new JComboBox(sidesNo);
    JButton drawButton = new JButton("Draw");

    public Toolbar(DrawingFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Toolbar"));
        init();
        this.setLayout(new GridLayout(2,4, 20, 0));
    }

    private void init() {
        sidesNoValue.setSelectedIndex(3);
        shapesStroke.setText("7");
        shapesNo.setText("5");
        add(sideLabel);
        add(shapeNoLabel);
        add(strokeLabel);
        add(drawButton);
        add(sidesNoValue);
        add(shapesNo);
        add(shapesStroke);
    }

}
