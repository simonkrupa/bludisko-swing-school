package sk.stuba.fei.uim.oop.gui.listeners;


import sk.stuba.fei.uim.oop.gui.logic.PlayerMovement;
import sk.stuba.fei.uim.oop.gui.panels.MazePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
    private MazePanel mazePanel;
    private PlayerMovement player;

    public MyMouseListener(MazePanel mazePanel, PlayerMovement player) {
        this.mazePanel = mazePanel;
        this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(mazePanel.getMaze().maze.get(player.playerPosition)==e.getComponent()){
            System.out.println("spravne");
        }
        System.out.println("u clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
