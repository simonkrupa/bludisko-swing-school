package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.gui.listeners.MyActionListener;
import sk.stuba.fei.uim.oop.gui.listeners.MyKeyListener;
import sk.stuba.fei.uim.oop.gui.logic.PlayerMovement;
import sk.stuba.fei.uim.oop.gui.panels.ButtonPanel;
import sk.stuba.fei.uim.oop.gui.panels.MazePanel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    public MazePanel mazePanel;
    public ButtonPanel buttonPanel;
    private PlayerMovement player;
    private int mazeWidthHeight = 13;
    private MyKeyListener keyListener;
    private MyActionListener actionListener;

    public Frame() throws HeadlessException {

        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        createPanels();
    }

    public void createPanels(){
        newMazePanel();
        newButtonPanel();
        this.repaint();
        this.setVisible(true);
    }


    public void newMazePanel(){
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
        this.player = new PlayerMovement(buttonPanel, this, mazeWidthHeight);
        player.move(mazePanel.getMaze().maze);

        this.actionListener = new MyActionListener(buttonPanel, player, this.mazePanel, mazeWidthHeight, this);
        buttonPanel.aButton.addActionListener(actionListener);
        buttonPanel.wButton.addActionListener(actionListener);
        buttonPanel.sButton.addActionListener(actionListener);
        buttonPanel.dButton.addActionListener(actionListener);
        buttonPanel.restartButton.addActionListener(actionListener);

        this.keyListener = new MyKeyListener(mazeWidthHeight, this.mazePanel, player);
        this.addKeyListener(keyListener);
    }
}
