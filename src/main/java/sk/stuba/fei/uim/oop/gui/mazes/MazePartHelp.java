package sk.stuba.fei.uim.oop.gui.mazes;

import javax.swing.*;
import java.awt.*;

public class MazePartHelp extends JPanel {

    private int position;
    private boolean visited = false;
    private boolean wall = false;
    private boolean lWall = true;
    private boolean rWall = true;
    private boolean uWall = true;
    private boolean dWall = true;
    private boolean player = false;
    private boolean start = false;
    private boolean finish = false;


    public MazePartHelp(int position) {
        this.position = position;
        this.repaint();
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        if (uWall) {
            g.drawLine(0, 0, this.getWidth(), 0);
        }
        if (lWall) {
            g.drawLine(0, 0, 0, this.getHeight());
        }
        if (rWall) {
            g.drawLine(this.getWidth() - 1, 0, this.getWidth() - 1, this.getHeight());
        }
        if (dWall) {
            g.drawLine(0, this.getHeight() - 1, this.getWidth(), this.getHeight() - 1);
        }
        if(player) {
            g.drawOval(0, 0, this.getWidth(), this.getHeight());
        }
        if(start){
            g.drawLine(0,0,this.getWidth(),this.getHeight());
            g.drawLine(0,this.getHeight(),this.getWidth(),0);
        }
        if(finish){
            g.drawLine(0,0,this.getWidth(),this.getHeight());
            g.drawLine(0,this.getHeight(),this.getWidth(),0);
        }
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

    public void setWall(boolean wall) {
        this.wall = wall;
        this.setBackground(Color.BLACK);
    }

    public boolean isWall() {
        return wall;
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

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean isFinish() {
        return finish;
    }
}
