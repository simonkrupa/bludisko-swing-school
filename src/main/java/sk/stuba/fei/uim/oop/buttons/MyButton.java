package sk.stuba.fei.uim.oop.buttons;

import sk.stuba.fei.uim.oop.MazePart;
import sk.stuba.fei.uim.oop.PlayerMovement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class MyButton extends JButton implements ActionListener {
    protected PlayerMovement player;
    protected ArrayList<MazePart> maze;

    public MyButton(String text, PlayerMovement player, ArrayList<MazePart> maze) {
        super(text);
        this.player = player;
        this.maze =maze;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("smth");
    }
}
