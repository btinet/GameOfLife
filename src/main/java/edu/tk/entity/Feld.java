package edu.tk.entity;

import java.awt.*;

public class Feld
{
    int status;
    int x,y;
    int breite;

    public Feld(int x, int y, int b)
    {
        status = 0;
        this.x = x;
        this.y = y;
        breite = b;
    }

    public boolean lebt() {
        return status != 0;
    }

    public void setzeStatus(int neuerStatus)
    {
        status = neuerStatus;
    }

    public void anzeigen(Graphics g)
    {
        g.setColor(new Color(60,60,60)); // hellgelb
        g.fillRect(50+x*breite,50+y*breite,breite,breite);
        g.setColor(new Color(0,0,0)); // schwarz
        g.drawRect(50+x*breite,50+y*breite,breite,breite);

        if (status == 1)
        {
            g.setColor(new Color(0,255,0)); // gruen
            g.fillOval(50+x*breite,50+y*breite,breite,breite);
        }
    }

    public int gibStatus() {
        return this.status;
    }
}