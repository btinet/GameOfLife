package edu.tk.entity;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ZAutomat extends JFrame implements ActionListener
{
    Spielbrett brett;
    Button   weiter;

    public ZAutomat()
    {
        initFelder();
        initButtons();

        setSize(500,580);
        setTitle("Ein zellulärer Automat");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void initFelder()
    {
        brett = new Spielbrett();
    }

    public void initButtons()
    {
        weiter = new Button("Evolution");
        add(weiter);
        setLayout(null);
        weiter.setBounds(200,440,100,30);
        weiter.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
        brett.neueRunde();
        repaint();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        brett.anzeigen(g);
    }

    public static void main(String[] args)
    {
        new ZAutomat();
    }
}
