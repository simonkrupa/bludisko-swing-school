package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() throws HeadlessException {

        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        MazePanel mazePanel = new MazePanel();
        this.add(mazePanel);

        PlayerMovement player = new PlayerMovement();
        player.move(mazePanel.getMaze().maze);

        ButtonPanel buttonPanel = new ButtonPanel(player, mazePanel.getMaze().maze);
        this.add(buttonPanel, BorderLayout.NORTH);
        this.repaint();
        this.setVisible(true);
    }
}
