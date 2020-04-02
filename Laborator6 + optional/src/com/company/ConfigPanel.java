package com.company;

import javax.swing.*;

import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel; 
    JSpinner sidesField; 
    JComboBox colorCombo; 

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); 
        
        colorCombo= new JComboBox(new String[]{"Random","Black"});
         
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}
