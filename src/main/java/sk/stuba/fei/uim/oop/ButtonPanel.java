package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.buttons.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonPanel extends JPanel{
    public WButton wButton;
    public AButton aButton;
    public SButton sButton;
    public DButton dButton;
    public RestartButton restartButton;

    public ButtonPanel(PlayerMovement player, ArrayList<MazePart> maze, Frame frame) {

        restartButton = new RestartButton("RESTART", frame);
        wButton = new WButton("Up", frame);
        aButton = new AButton("Left", frame);
        sButton = new SButton("Down", frame);
        dButton = new DButton("Right", frame);

        var layout = new GridLayout(2,3);
        this.setLayout(layout);

        this.add(restartButton);
        this.add(wButton);
        this.add(new JLabel());
        this.add(aButton);
        this.add(sButton);
        this.add(dButton);

    }

}
