package com.company;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
        canvas = new DrawingPanel(this);
        configPanel= new ConfigPanel(this);
        controlPanel= new ControlPanel(this);
      
        this.add(canvas, BorderLayout.CENTER );
        this.add(configPanel,BorderLayout.NORTH);
        this.add(controlPanel,BorderLayout.SOUTH);

        pack();
    }
}
