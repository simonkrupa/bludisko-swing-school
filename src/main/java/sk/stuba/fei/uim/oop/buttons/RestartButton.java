package sk.stuba.fei.uim.oop.buttons;

import sk.stuba.fei.uim.oop.MazePart;
import sk.stuba.fei.uim.oop.PlayerMovement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RestartButton extends MyButton implements ActionListener{
    public RestartButton(String text, PlayerMovement player, ArrayList<MazePart> maze) {
        super(text, player, maze);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("restart");
    }
}
