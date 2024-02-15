/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hubert.labirynt;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author student
 */
public class Maze {

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<RoomBomb> roomBombs = new ArrayList<>();

    public Room getRoomByNumber(int nr) {
        Iterator<Room> it = rooms.iterator();
        Room r;
        while (it.hasNext()) {
            r = it.next();
            if (r.getNumber() == nr) {
                return r;
            }
        }
        return null;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
    
     public void addRoomBomb(RoomBomb roomBomb) {
        roomBombs.add(roomBomb);
    }

    public Image drawMaze(Image image) {
        Iterator<Room> it = rooms.iterator();
        Room r;
        while (it.hasNext()) {
            r = it.next();
            r.draw(image);
        }
        
        return image;
    }
    
}
