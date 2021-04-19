package sk.stuba.fei.uim.oop.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DButton extends MyButton implements ActionListener {

    public DButton(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Right");
    }
}
