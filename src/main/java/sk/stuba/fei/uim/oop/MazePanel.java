package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {
    private Maze maze;
    public MazePanel() {
        maze = new Maze();
        int mazeWidthHeight = maze.getMazeWidthHeight();
        this.setLayout(new GridLayout(mazeWidthHeight,mazeWidthHeight));
        for(int i=0; i<mazeWidthHeight; i++){
            for(int j = 0;j<mazeWidthHeight;j++){
                this.add(maze.maze.get(mazeWidthHeight*i+j));
            }
        }
        this.repaint();
    }

    public Maze getMaze() {
        return maze;
    }

    public void restart(){
        MazePanel mazePanel = new MazePanel();
    }
}
