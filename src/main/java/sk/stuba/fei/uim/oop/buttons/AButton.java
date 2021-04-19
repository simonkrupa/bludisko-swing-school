package sk.stuba.fei.uim.oop.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AButton extends MyButton implements ActionListener {

    public AButton(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Left");
    }
}
