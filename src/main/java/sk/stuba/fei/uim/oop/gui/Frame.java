package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.gui.listeners.MyActionListener;
import sk.stuba.fei.uim.oop.gui.listeners.MyKeyListener;
import sk.stuba.fei.uim.oop.gui.listeners.MyMouseListener;
import sk.stuba.fei.uim.oop.gui.logic.PlayerMovement;
import sk.stuba.fei.uim.oop.gui.panels.ButtonPanel;
import sk.stuba.fei.uim.oop.gui.panels.MazePanel;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    public MazePanel mazePanel;
    public ButtonPanel buttonPanel;
    private PlayerMovement player;
    private int mazeWidthHeight = 13;
    private MyKeyListener keyListener;
    private MyActionListener actionListener;
    private MyMouseListener mouseListener;

    public Frame() throws HeadlessException {

        this.setSize(599,674);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        createPanels();
    }

    public MyMouseListener getMouseListener() {
        return mouseListener;
    }

    public void createPanels(){
        newMazePanel();
        newButtonPanel();
        this.repaint();
        this.setVisible(true);
    }


    private void newMazePanel(){
        this.mazePanel = new MazePanel(mazeWidthHeight);
        this.add(mazePanel);
        this.repaint();
        this.setVisible(true);
    }

    public void removeListeners(){
        buttonPanel.aButton.removeActionListener(actionListener);
        buttonPanel.wButton.removeActionListener(actionListener);
        buttonPanel.sButton.removeActionListener(actionListener);
        buttonPanel.dButton.removeActionListener(actionListener);
        buttonPanel.restartButton.removeActionListener(actionListener);
        this.removeKeyListener(keyListener);
        for(int i=0; i<mazeWidthHeight*mazeWidthHeight;i++) {
            mazePanel.getMaze().maze.get(i).removeMouseListener(mouseListener);
        }
    }

    public void finishedGame(){
        buttonPanel.setCount();
        this.remove(mazePanel);
        validate();
        repaint();
        removeListeners();
        this.newMazePanel();
        createListeners();
    }

    private void newButtonPanel(){
        this.buttonPanel = new ButtonPanel();
        this.add(buttonPanel, BorderLayout.NORTH);
        createListeners();
    }

    private void createListeners(){
        this.player = new PlayerMovement(this, mazeWidthHeight);
        player.move(mazePanel.getMaze().maze);

        this.actionListener = new MyActionListener(buttonPanel, player, this.mazePanel, mazeWidthHeight, this);
        buttonPanel.aButton.addActionListener(actionListener);
        buttonPanel.wButton.addActionListener(actionListener);
        buttonPanel.sButton.addActionListener(actionListener);
        buttonPanel.dButton.addActionListener(actionListener);
        buttonPanel.restartButton.addActionListener(actionListener);

        this.mouseListener = new MyMouseListener(mazePanel,player,this);
        for(int i=0; i<mazeWidthHeight*mazeWidthHeight;i++) {
            mazePanel.getMaze().maze.get(i).addMouseListener(mouseListener);
        }

        this.keyListener = new MyKeyListener(mazeWidthHeight, this.mazePanel, player, this);
        this.addKeyListener(keyListener);
    }
}
