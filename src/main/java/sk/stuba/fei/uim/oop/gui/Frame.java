package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.gui.mazes.logic.PlayerMovement;
import sk.stuba.fei.uim.oop.gui.panels.ButtonPanel;
import sk.stuba.fei.uim.oop.gui.panels.MazePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener, ActionListener {
    public MazePanel mazePanel;
    private ButtonPanel buttonPanel;
    private PlayerMovement player;
    private int mazeWidthHeight = 13;

    public Frame() throws HeadlessException {

        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.addKeyListener(this);

        createPanels();
    }

    private void createPanels(){
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

    private void newButtonPanel(){
        this.buttonPanel = new ButtonPanel(this);
        this.add(buttonPanel, BorderLayout.NORTH);
        this.player = new PlayerMovement(buttonPanel, this, mazeWidthHeight);
        player.move(mazePanel.getMaze().maze);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonPanel.wButton){
            System.out.println("Up");
            player.setPlayerPosition(-mazeWidthHeight, mazePanel.getMaze().maze);
        }
        if(e.getSource()==buttonPanel.aButton){
            System.out.println("Left");
            player.setPlayerPosition(-1, mazePanel.getMaze().maze);
        }
        if(e.getSource()==buttonPanel.sButton){
            System.out.println("Down");
            player.setPlayerPosition(mazeWidthHeight, mazePanel.getMaze().maze);
        }
        if(e.getSource()==buttonPanel.dButton){
            System.out.println("Right");
            player.setPlayerPosition(1, mazePanel.getMaze().maze);
        }
        if(e.getSource()==buttonPanel.restartButton){
            System.out.println("restart");
            this.remove(mazePanel);
            this.remove(buttonPanel);
            createPanels();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            System.out.println("Up");
            player.setPlayerPosition(-mazeWidthHeight, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_A) {
            System.out.println("Left");
            player.setPlayerPosition(-1, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_S) {
            System.out.println("Down");
            player.setPlayerPosition(mazeWidthHeight, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_D) {
            System.out.println("Right");
            player.setPlayerPosition(1, mazePanel.getMaze().maze);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}