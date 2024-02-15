/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hubert.labirynt;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author student
 */
public class Room extends MapSite
{
    private int nr;
    private MapSite [] sides = new MapSite[4];
    private int x, y; //swpolrzedne pokoju
    
    public Room(int nr, int x, int y)
    {
        this.nr = nr;
        this.x = x;
        this.y = y;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    
    public int getNumber(){
        return this.nr;
    }
    
    public void setSide(Direction direction, MapSite mapSite)
    {
        switch (direction)
        {
            case North:
                if (mapSite instanceof Wall)
                {
                    ((Wall)mapSite).setX(x);
                    ((Wall)mapSite).setY(y);
                }
                sides[0] = mapSite;
            break;
            case East:
                if (mapSite instanceof Wall)
                {
                    ((Wall)mapSite).setX(x + LENGTH);
                    ((Wall)mapSite).setY(y);
                }
                sides[1] = mapSite;
            break;
            case South:
                if (mapSite instanceof Wall)
                {
                    ((Wall)mapSite).setX(x);
                    ((Wall)mapSite).setY(y + LENGTH);
                }
                sides[2] = mapSite;
            break;
            case West:
                if (mapSite instanceof Wall)
                {
                    ((Wall)mapSite).setX(x);
                    ((Wall)mapSite).setY(y);
                }
                sides[3] = mapSite;
        }
    }
    
    @Override
    public void draw(Image image)
    {
        Graphics g = image.getGraphics();
        for(MapSite ms:sides)
            if (ms != null)
                ms.draw(image);
        g.drawString("" + nr, x + 5, y + 12);
    }
}
