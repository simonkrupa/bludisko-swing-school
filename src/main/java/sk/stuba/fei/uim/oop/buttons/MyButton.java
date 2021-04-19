package sk.stuba.fei.uim.oop.buttons;

import sk.stuba.fei.uim.oop.Frame;
import javax.swing.*;

public abstract class MyButton extends JButton {
    protected Frame frame;

    public MyButton(String text, Frame frame) {
        super(text);
        this.frame = frame;
        addActionListener(frame);
        setFocusable(false);
    }
}
