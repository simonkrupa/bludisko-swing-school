package sk.stuba.fei.uim.oop.gui.buttons;

import javax.swing.*;

public abstract class MyButton extends JButton {

    public MyButton(String text) {
        super(text);
        setFocusable(false);
    }
}
