package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.buttons.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonPanel extends JPanel{

    public ButtonPanel(PlayerMovement player, ArrayList<MazePart> maze) {
        /*
        JButton wButton = new JButton("w");
        JButton aButton = new JButton("a");
        JButton sButton = new JButton("s");
        JButton dButton = new JButton("d");
         */
        //JButton restartButton = new JButton("RESTART");
        var restartButton = new RestartButton("RESTART", player, maze);
        var wButton = new WButton("Up", player, maze);
        var aButton = new AButton("Left", player, maze);
        var sButton = new SButton("Down", player, maze);
        var dButton = new DButton("Right", player, maze);

        var layout = new GridLayout(2,3);
        this.setLayout(layout);

        this.add(restartButton);
        this.add(wButton);
        this.add(new JLabel());
        this.add(aButton);
        this.add(sButton);
        this.add(dButton);
        /*
        var wsPanel = new JPanel();
        wsPanel.setLayout(new BorderLayout());
        wsPanel.add(wButton, BorderLayout.NORTH);
        wsPanel.add(sButton, BorderLayout.SOUTH);

        aButton.setPreferredSize(new Dimension(150,80));
        wsPanel.setPreferredSize(new Dimension(200, 80));
        sButton.setPreferredSize(new Dimension(200,40));
        wButton.setPreferredSize(new Dimension(200,40));
        dButton.setPreferredSize(new Dimension(150,80));
        restartButton.setPreferredSize(new Dimension(500,20));

        this.add(aButton, BorderLayout.LINE_START);
        this.add(wsPanel, BorderLayout.CENTER);
        this.add(dButton, BorderLayout.LINE_END);
        this.add(restartButton, BorderLayout.PAGE_END);

         */
    }

}
