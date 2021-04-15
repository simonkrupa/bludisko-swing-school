package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() throws HeadlessException {
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        ButtonPanel buttonPanel = new ButtonPanel();

        this.add(buttonPanel, BorderLayout.NORTH);

        this.setVisible(true);
    }
}