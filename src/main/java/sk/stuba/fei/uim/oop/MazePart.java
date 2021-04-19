package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MazePart extends JPanel {

    public int position;
    public ArrayList<MazePart> neighbours;
    public boolean visited = false;
    public int i;
    public int j;
    public boolean wall = false;
    //TESTOVANIE V KONZOLE
    public char pis = 's';
    public boolean lWall = true;
    public boolean rWall = true;
    public boolean uWall = true;
    public boolean dWall = true;

    public MazePart(int position, int i, int j) {
        this.position = position;
        this.i = i;
        this.j = j;

        //TEST
        if(pis=='s'){
            this.setBackground(Color.BLUE);
        }else if(pis=='X'){
            this.setBackground(Color.BLACK);
        }else if(pis=='m'){
            this.setBackground(Color.GREEN);
        }
        //this.setBackground(Color.GREEN);
        this.setVisible(true);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
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
    }

    public int getPosition() {
        return position;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
        this.pis = 'm';
        this.setBackground(Color.GREEN);
    }

    public void setPis(char pis) {
        this.pis = pis;
        this.setBackground(Color.BLACK);
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
}
