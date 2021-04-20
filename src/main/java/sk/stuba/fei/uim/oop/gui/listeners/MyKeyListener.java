package sk.stuba.fei.uim.oop.gui.listeners;

import sk.stuba.fei.uim.oop.gui.logic.PlayerMovement;
import sk.stuba.fei.uim.oop.gui.panels.MazePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    private int mazeWidthHeight;
    private MazePanel mazePanel;
    private PlayerMovement player;

    public MyKeyListener(int mazeWidthHeight, MazePanel mazePanel, PlayerMovement player) {
        this.mazeWidthHeight = mazeWidthHeight;
        this.mazePanel = mazePanel;
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            //System.out.println("Up");
            System.out.println(player.playerPosition);
            player.setPlayerPosition(-mazeWidthHeight, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_A) {
            //System.out.println("Left");
            System.out.println(player.playerPosition);

            player.setPlayerPosition(-1, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_S) {
            //System.out.println("Down");
            System.out.println(player.playerPosition);

            player.setPlayerPosition(mazeWidthHeight, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_D) {
            //System.out.println("Right");
            System.out.println(player.playerPosition);

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
