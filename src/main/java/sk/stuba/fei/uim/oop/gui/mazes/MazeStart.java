package sk.stuba.fei.uim.oop.gui.mazes;

import java.awt.*;

public class MazeStart extends MazeCell{
    public MazeStart(int position) {
        super(position);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0,0,this.getWidth(),this.getHeight());
        g.drawLine(0,this.getHeight(),this.getWidth(),0);
    }
}
