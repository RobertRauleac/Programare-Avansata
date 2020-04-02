package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class ControlPanel extends JPanel {
    final MainFrame frame;

    Deque<BufferedImage> undoStack= new LinkedList<>();
    Deque<BufferedImage> redoStack= new LinkedList<>();
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    JButton undo = new JButton("Undo");
    JButton redo = new JButton("Redo");

    String returnFile;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        final JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose a directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(frame.controlPanel);
        if (returnVal == JFileChooser.APPROVE_OPTION)
            returnFile= chooser.getSelectedFile().toString();
        init();
    }
    private void init() {
        
        setLayout(new GridLayout(3, 8));
        
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        add(undo);
        add(redo);
       
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        undo.addActionListener(this::undoCall);
        redo.addActionListener(this::redoCall);
    }
    public void undoAdd(BufferedImage img){
        BufferedImage imageForStack = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        Graphics2D graphics2D = imageForStack.createGraphics();
        graphics2D.drawImage(img, 0, 0, null);
        undoStack.push(imageForStack);
    }
    public void redoAdd(BufferedImage img){
        BufferedImage imageForStack = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        Graphics2D graphics2D = imageForStack.createGraphics();
        graphics2D.drawImage(img, 0, 0, null);
        redoStack.push(imageForStack);
    }
    private void undoCall(ActionEvent e){
        if(undoStack.size()>0){
            redoAdd(frame.canvas.image);
            BufferedImage img = undoStack.pop();
            frame.canvas.graphics.drawImage(img,0,0,null);
            frame.canvas.repaint();
        }
    }
    private void redoCall(ActionEvent e){
        if(redoStack.size()>0){
            undoAdd(frame.canvas.image);
            BufferedImage img = redoStack.pop();
            frame.canvas.graphics.drawImage(img,0,0,null);
            frame.canvas.repaint();
        }
    }
    private void save(ActionEvent e) {
        try {
            if(returnFile!=null)
                ImageIO.write(frame.canvas.image, "PNG", new File(returnFile+"/img.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e) {
        try {
            if(returnFile!=null){
                frame.canvas.graphics.drawImage(ImageIO.read(new File(returnFile+"/img.png")),0,0,null);
                frame.canvas.repaint();
            }
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e) {
        try {
            frame.canvas.graphics.setColor(Color.white);
            frame.canvas.graphics.fillRect(0,0,frame.canvas.image.getWidth(),frame.canvas.image.getHeight());
            frame.canvas.repaint();
        } catch (Exception ex) { System.err.println(ex); }
    }
    private void exit(ActionEvent e) {
        try {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } catch (Exception ex) { System.err.println(ex); }
    }
}