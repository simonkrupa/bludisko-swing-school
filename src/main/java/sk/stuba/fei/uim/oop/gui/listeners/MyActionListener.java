package sk.stuba.fei.uim.oop.gui.listeners;

import sk.stuba.fei.uim.oop.gui.Frame;
import sk.stuba.fei.uim.oop.gui.logic.PlayerMovement;
import sk.stuba.fei.uim.oop.gui.panels.ButtonPanel;
import sk.stuba.fei.uim.oop.gui.panels.MazePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private ButtonPanel buttonPanel;
    private PlayerMovement player;
    private MazePanel mazePanel;
    private int mazeWidthHeight;
    private Frame frame;

    public MyActionListener(ButtonPanel buttonPanel, PlayerMovement player, MazePanel mazePanel, int mazeWidthHeight, Frame frame) {
        this.buttonPanel = buttonPanel;
        this.player = player;
        this.mazePanel = mazePanel;
        this.mazeWidthHeight = mazeWidthHeight;
        this.frame = frame;
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
            frame.remove(frame.mazePanel);
            frame.remove(frame.buttonPanel);
            frame.repaint();
            frame.removeListeners();
            frame.createPanels();
        }
    }
}
