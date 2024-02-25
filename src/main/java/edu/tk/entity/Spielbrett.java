package edu.tk.entity;

import java.awt.*;
import java.util.Random;

public class Spielbrett {
    Feld[][] feld;
    int groesse, breite;
    Random wuerfel;
    Feld[][] altesFeld, neuesFeld;

    public Spielbrett()
    {
        groesse = 100;
        breite  =   4;
        altesFeld = new Feld[groesse][groesse];
        neuesFeld = new Feld[groesse][groesse];
        wuerfel = new Random();

        for (int x=0; x < groesse; x++)
            for (int y=0; y < groesse; y++)
            {
                altesFeld[x][y] = new Feld(x,y,breite);
                neuesFeld[x][y] = new Feld(x,y,breite);
                if (wuerfel.nextInt(10) < 3)
                    altesFeld[x][y].setzeStatus(1);
            }
    }

    private int anzahlNachbarn(int x, int y)
    {
        int nachbarn = 0;
        int xl, xr, yo, yu;

        if (x ==  0) xl = 99; else xl = x-1;
        if (x == 99) xr =  0; else xr = x+1;
        if (y ==  0) yo = 99; else yo = y-1;
        if (y == 99) yu =  0; else yu = y+1;

        if (altesFeld[xl][ y].lebt()) nachbarn++;
        if (altesFeld[xr][ y].lebt()) nachbarn++;
        if (altesFeld[ x][yo].lebt()) nachbarn++;
        if (altesFeld[ x][yu].lebt()) nachbarn++;
        return nachbarn;
    }

    private void neuerStatusFeld(int x, int y)
    {
        int n = anzahlNachbarn(x,y);

        if (n <= 0) neuesFeld[x][y].setzeStatus(0); else
        if (n <= 3) neuesFeld[x][y].setzeStatus(1); else
        if (n >= 4) neuesFeld[x][y].setzeStatus(0);
    }

    public void neueRunde()
    {
        for (int x=0; x < groesse; x++)
            for (int y=0; y < groesse; y++)
                neuerStatusFeld(x,y);

        for (int x=0; x < groesse; x++)
            for (int y=0; y < groesse; y++)
                altesFeld[x][y].setzeStatus(neuesFeld[x][y].gibStatus());
    }

    public void anzeigen(Graphics g)
    {
        for (int x=0; x < groesse; x++)
            for (int y=0; y < groesse; y++)
                altesFeld[x][y].anzeigen(g);
    }

}