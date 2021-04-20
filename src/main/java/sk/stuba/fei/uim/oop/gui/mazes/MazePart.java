package sk.stuba.fei.uim.oop.gui.mazes;

import javax.swing.*;
import java.awt.*;

public abstract class MazePart extends JPanel {
    protected boolean lWall = true;
    protected boolean rWall = true;
    protected boolean uWall = true;
    protected boolean dWall = true;
    protected int position;
    protected boolean visited = false;
    protected boolean player = false;

    public MazePart(int position) {
        this.position = position;
        this.repaint();
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public int getPosition() {
        return position;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;

    }

    public void setlWall(boolean lWall) {
        this.lWall = lWall;
    }

    public void setrWall(boolean rWall) {
        this.rWall = rWall;
    }

    public void setuWall(boolean uWall) {
        this.uWall = uWall;
    }

    public void setdWall(boolean dWall) {
        this.dWall = dWall;
    }

    public boolean islWall() {
        return lWall;
    }

    public boolean isrWall() {
        return rWall;
    }

    public boolean isuWall() {
        return uWall;
    }

    public boolean isdWall() {
        return dWall;
    }

}
