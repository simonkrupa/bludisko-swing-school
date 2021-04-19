package sk.stuba.fei.uim.oop.buttons;

import sk.stuba.fei.uim.oop.MazePart;
import sk.stuba.fei.uim.oop.PlayerMovement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AButton extends MyButton implements ActionListener {

    public AButton(String text, PlayerMovement player, ArrayList<MazePart> maze) {
        super(text, player, maze);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Left");
        player.setPlayerPosition(-1, maze);

    }
}
