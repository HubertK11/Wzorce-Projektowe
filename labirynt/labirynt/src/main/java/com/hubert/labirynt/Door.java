/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hubert.labirynt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Door extends MapSite {

    private Room room1;
    private Room room2;
    private boolean isOpen;

    public Room otherSideFrom(Room room) {
        if (room == room1) {
            return room2;
        }
        if (room == room2) {
            return room1;
        }
        return null;
    }

    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    public Room getRoom1() {
        return room1;
    }

    public Room getRoom2() {
        return room2;
    }

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        int x1 = room1.getx();
        int y1 = room1.gety();
        int x2 = room2.getx();
        int y2 = room2.gety();
           g.setColor(Color.red);
        if (y1 != y2) { //
            //
            int maxy = y1 > y2 ? y1 : y2;

            g.drawLine(x1, maxy, x1 + LENGTH / 3, maxy);
            g.drawLine(x1 + 2 * LENGTH / 3, maxy, x1 + LENGTH, maxy);
        } else {
            int maxx = x1 > x2 ? x1 : x2;

            g.drawLine(maxx, y1, maxx , y1+ LENGTH / 3);
            g.drawLine(maxx , y1 +2 * LENGTH / 3, maxx, y1+ LENGTH );
        }
        g.setColor(Color.black);
    }
}
