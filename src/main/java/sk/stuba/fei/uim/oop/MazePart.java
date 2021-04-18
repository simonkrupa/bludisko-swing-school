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
    //TESTOVANIE V KONZOLE
    public char pis = 's';

    public MazePart(int position, int i, int j) {
        this.position = position;
        this.i = i;
        this.j = j;

        this.setBackground(Color.GREEN);
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
        g.drawLine(0,0,this.getWidth(),0);
        g.drawLine(0,0,0,this.getHeight());
        g.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight());
        g.drawLine(0,this.getHeight()-1,this.getWidth(),this.getHeight()-1);
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
    }

}
