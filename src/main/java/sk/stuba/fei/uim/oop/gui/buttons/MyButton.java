package sk.stuba.fei.uim.oop.gui.buttons;

import sk.stuba.fei.uim.oop.gui.Frame;
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
