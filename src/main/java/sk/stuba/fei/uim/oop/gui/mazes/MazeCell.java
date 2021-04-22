package sk.stuba.fei.uim.oop.gui.mazes;

import java.awt.*;
import java.util.ArrayList;

public class MazeCell extends MazePart {

    public MazeCell(int position) {
        super(position);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        if(mouse && player){
            this.setBackground(Color.CYAN);
            this.setBackground(Color.CYAN);
        }else if (mouse){
            this.setBackground(Color.YELLOW);
            this.setBackground(Color.YELLOW);
        }else{
            this.setBackground(Color.WHITE);
        }
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
    }

}
