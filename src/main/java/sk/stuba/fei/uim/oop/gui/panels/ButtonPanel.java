package sk.stuba.fei.uim.oop.gui.panels;

import sk.stuba.fei.uim.oop.gui.buttons.*;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{
    public WButton wButton;
    public AButton aButton;
    public SButton sButton;
    public DButton dButton;
    public RestartButton restartButton;
    public JLabel counter;
    public int count = 0;

    public ButtonPanel() {

        restartButton = new RestartButton("RESTART");
        wButton = new WButton("Up");
        aButton = new AButton("Left");
        sButton = new SButton("Down");
        dButton = new DButton("Right");

        counter = new JLabel("Win counter: " + count);

        var layout = new GridLayout(2,3);
        this.setLayout(layout);

        this.add(restartButton);
        this.add(wButton);
        this.add(counter);
        this.add(aButton);
        this.add(sButton);
        this.add(dButton);

    }

    public void setCount() {
        this.count = this.count + 1;
        counter.setText("Win counter: " + count);
    }
}
