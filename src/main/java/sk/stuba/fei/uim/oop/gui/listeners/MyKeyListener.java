package sk.stuba.fei.uim.oop.gui.listeners;

import sk.stuba.fei.uim.oop.gui.Frame;
import sk.stuba.fei.uim.oop.gui.logic.PlayerMovement;
import sk.stuba.fei.uim.oop.gui.panels.MazePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    private int mazeWidthHeight;
    private MazePanel mazePanel;
    private PlayerMovement player;
    private Frame frame;

    public MyKeyListener(int mazeWidthHeight, MazePanel mazePanel, PlayerMovement player, Frame frame) {
        this.mazeWidthHeight = mazeWidthHeight;
        this.mazePanel = mazePanel;
        this.player = player;
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            System.out.println(player.playerPosition);
            player.setPlayerPosition(-mazeWidthHeight, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_A) {
            System.out.println(player.playerPosition);
            player.setPlayerPosition(-1, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_S) {
            System.out.println(player.playerPosition);
            player.setPlayerPosition(mazeWidthHeight, mazePanel.getMaze().maze);
        }
        if(key == KeyEvent.VK_D) {
            System.out.println(player.playerPosition);
            player.setPlayerPosition(1, mazePanel.getMaze().maze);
        }
        frame.getMouseListener().cancelMouse();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
