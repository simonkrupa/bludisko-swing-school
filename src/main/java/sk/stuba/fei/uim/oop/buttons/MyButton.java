package sk.stuba.fei.uim.oop.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class MyButton extends JButton implements ActionListener {

    public MyButton(String text) {
        super(text);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("smth");
    }
}
