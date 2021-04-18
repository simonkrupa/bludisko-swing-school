package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {
    public MazePanel() {
        this.setLayout(new GridLayout(11,11));
        for(int i=0; i<11; i++){
            for(int j = 0;j<11;j++){
                this.add(new MazePart(i, i, i));
            }
        }
    }
}
