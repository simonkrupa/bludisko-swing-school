package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{

    public ButtonPanel() {
        JButton wButton = new JButton("w");
        JButton aButton = new JButton("a");
        JButton sButton = new JButton("s");
        JButton dButton = new JButton("d");
        JButton restartButton = new JButton("RESTART");

        this.setBackground(Color.YELLOW);
        var layout = new BorderLayout();
        this.setLayout(layout);

        var wsPanel = new JPanel();
        wsPanel.setLayout(new BorderLayout());
        wsPanel.add(wButton, BorderLayout.NORTH);
        wsPanel.add(sButton, BorderLayout.SOUTH);

        aButton.setPreferredSize(new Dimension(150,80));
        wsPanel.setPreferredSize(new Dimension(200, 80));
        sButton.setPreferredSize(new Dimension(200,40));
        wButton.setPreferredSize(new Dimension(200,40));
        dButton.setPreferredSize(new Dimension(150,80));
        restartButton.setPreferredSize(new Dimension(500,20));

        this.add(aButton, BorderLayout.LINE_START);
        this.add(wsPanel, BorderLayout.CENTER);
        this.add(dButton, BorderLayout.LINE_END);
        this.add(restartButton, BorderLayout.PAGE_END);
    }

}
