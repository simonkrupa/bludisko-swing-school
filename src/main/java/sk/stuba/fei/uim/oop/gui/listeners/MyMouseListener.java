package sk.stuba.fei.uim.oop.gui.listeners;


import sk.stuba.fei.uim.oop.gui.logic.PlayerMovement;
import sk.stuba.fei.uim.oop.gui.mazes.MazePart;
import sk.stuba.fei.uim.oop.gui.panels.MazePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MyMouseListener implements MouseListener {
    private MazePanel mazePanel;
    private PlayerMovement player;
    private ArrayList<MazePart> way = new ArrayList<>();
    private Frame frame;

    public MyMouseListener(MazePanel mazePanel, PlayerMovement player, Frame frame) {
        this.mazePanel = mazePanel;
        this.player = player;
        this.frame = frame;
    }

    private boolean containsArray(Component mazePart){
        for(var mazePartWay:way){
            if (mazePart == mazePartWay){
                return true;
            }
        }
        return false;
    }

    public void cancelMouse(){
        for (var mazePart:mazePanel.getMaze().maze){
            mazePart.setMouse(false);
            mazePart.repaint();
        }
        way.clear();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        var mazeParte = e.getComponent();

        if (mazeParte!=mazePanel.getMaze().maze.get(player.playerPosition) && !containsArray(e.getComponent())){
            mazePanel.getMaze().maze.get(player.playerPosition).setMouse(false);
            for (var mazePart : way){
                mazePart.setMouse(false);
                mazePart.repaint();
            }
            this.way.clear();
        }else if (e.getComponent()==mazePanel.getMaze().maze.get(player.playerPosition)) {
            mazePanel.getMaze().maze.get(player.playerPosition).setMouse(true);
            this.way = mazePanel.getMaze().maze.get(player.playerPosition).findWay(mazePanel.getMaze().maze, mazePanel);
        }else if (containsArray(e.getComponent())){
            for(var mazePart : mazePanel.getMaze().maze){
                if (mazePart == mazeParte){
                    for (var mazePartWay : way){
                        mazePartWay.setMouse(false);
                        mazePartWay.repaint();
                    }
                    player.moveMouse(mazePanel.getMaze().maze, mazePart.getPosition());
                    break;
                }
            }
            way.clear();
        }
        frame.repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!way.isEmpty()) {
            for (var mazePart : way) {
                if (mazePart == e.getComponent()) {
                    mazePart.setMouse(true);
                    mazePart.repaint();
                    frame.repaint();
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!way.isEmpty()) {
            for (var mazePart : way) {
                if (mazePart == e.getComponent()) {
                    mazePart.setMouse(false);
                    mazePart.repaint();
                    frame.repaint();
                }
            }
        }
    }
}
