package sk.stuba.fei.uim.oop;

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

    public Frame() throws HeadlessException {

        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.addKeyListener(this);

        createPanels();

        this.repaint();
        this.setVisible(true);
    }

    private void createPanels(){
        newMazePanel();
        newButtonPanel();
    }

    private void newMazePanel(){
        this.mazePanel = new MazePanel();
        this.add(mazePanel);
        this.player = new PlayerMovement();
        player.move(mazePanel.getMaze().maze);
    }

    private void newButtonPanel(){
        this.buttonPanel = new ButtonPanel(player, mazePanel.getMaze().maze, this);
        this.add(buttonPanel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonPanel.wButton){
            System.out.println("Up");
            player.setPlayerPosition(-13, mazePanel.getMaze().maze);
        }
        if(e.getSource()==buttonPanel.aButton){
            System.out.println("Left");
            player.setPlayerPosition(-1, mazePanel.getMaze().maze);
        }
        if(e.getSource()==buttonPanel.sButton){
            System.out.println("Down");
            player.setPlayerPosition(13, mazePanel.getMaze().maze);
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

            this.repaint();
            this.setVisible(true);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            System.out.println("Up");
            player.setPlayerPosition(-13, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_A) {
            System.out.println("Left");
            player.setPlayerPosition(-1, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_S) {
            System.out.println("Down");
            player.setPlayerPosition(13, mazePanel.getMaze().maze);
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
