package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {
    private Maze maze;
    private int mazeWidthHeight;

    public MazePanel(int mazeWidthHeight) {
        this.mazeWidthHeight = mazeWidthHeight;
        maze = new Maze(mazeWidthHeight);
        this.setLayout(new GridLayout(this.mazeWidthHeight,this.mazeWidthHeight));
        for(int i=0; i<this.mazeWidthHeight; i++){
            for(int j = 0;j<this.mazeWidthHeight;j++){
                this.add(maze.maze.get(this.mazeWidthHeight*i+j));
            }
        }
        this.repaint();
    }

    public Maze getMaze() {
        return maze;
    }

}
