package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {
    public MazePanel() {
        this.setLayout(new GridLayout(13,13));
        /*for(int i=0; i<11; i++){
            for(int j = 0;j<11;j++){
                this.add(new MazePart(i, i, i));
            }
        }*/
        Maze maze = new Maze();
        for(int i=0; i<13; i++){
            for(int j = 0;j<13;j++){
                this.add(maze.maze.get(13*i+j));
            }
        }
        this.repaint();
    }
}
