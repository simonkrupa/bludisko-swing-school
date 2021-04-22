package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.gui.listeners.MyActionListener;
import sk.stuba.fei.uim.oop.gui.listeners.MyKeyListener;
import sk.stuba.fei.uim.oop.gui.logic.PlayerMovement;
import sk.stuba.fei.uim.oop.gui.mazes.MazePart;
import sk.stuba.fei.uim.oop.gui.panels.ButtonPanel;
import sk.stuba.fei.uim.oop.gui.panels.MazePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Frame extends JFrame implements MouseListener {
    public MazePanel mazePanel;
    public ButtonPanel buttonPanel;
    private PlayerMovement player;
    private int mazeWidthHeight = 13;
    private MyKeyListener keyListener;
    private MyActionListener actionListener;
    private ArrayList<MazePart> way = new ArrayList<>();

    public Frame() throws HeadlessException {

        this.setSize(599,674);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        createPanels();
    }

    public void setWay(ArrayList<MazePart> way) {
        this.way = way;
    }

    public void cancelMouse(){
        for (var mazePart:mazePanel.getMaze().maze){
            mazePart.setMouse(false);
            mazePart.repaint();
        }
        way.clear();
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
        for(int i=0; i<mazeWidthHeight*mazeWidthHeight;i++) {
            mazePanel.getMaze().maze.get(i).removeMouseListener(this);
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
        this.player = new PlayerMovement(buttonPanel, this, mazeWidthHeight);
        player.move(mazePanel.getMaze().maze);

        this.actionListener = new MyActionListener(buttonPanel, player, this.mazePanel, mazeWidthHeight, this);
        buttonPanel.aButton.addActionListener(actionListener);
        buttonPanel.wButton.addActionListener(actionListener);
        buttonPanel.sButton.addActionListener(actionListener);
        buttonPanel.dButton.addActionListener(actionListener);
        buttonPanel.restartButton.addActionListener(actionListener);

        for(int i=0; i<mazeWidthHeight*mazeWidthHeight;i++) {
            mazePanel.getMaze().maze.get(i).addMouseListener(this);
        }

        this.keyListener = new MyKeyListener(mazeWidthHeight, this.mazePanel, player, this);
        this.addKeyListener(keyListener);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        var mazeParte = e.getComponent();

        if (mazeParte!=mazePanel.getMaze().maze.get(player.playerPosition) && !way.contains(mazeParte)){
            System.out.println("klik inde");
            mazePanel.getMaze().maze.get(player.playerPosition).setMouse(false);
            for (var mazePart : way){
                mazePart.setMouse(false);
                mazePart.repaint();
            }
            this.way.clear();
        }else if (e.getComponent()==mazePanel.getMaze().maze.get(player.playerPosition)) {
            mazePanel.getMaze().maze.get(player.playerPosition).setMouse(true);
            this.way = mazePanel.getMaze().maze.get(player.playerPosition).findWay(mazePanel.getMaze().maze);
            for (var mazePart : way){
                //mazePart.setMouse(true);
            }
        }else if (way.contains(mazeParte)){
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
        repaint();
    }

    private boolean containsArray(MazePart mazePart){
        for (var mazePartWay : way){
            if(mazePartWay==mazePart){
                return true;
            }
        }
        return false;
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
                    repaint();
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
                    repaint();
                }
            }
        }
    }
}
