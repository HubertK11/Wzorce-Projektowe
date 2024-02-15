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
public abstract class MapSite {
   
    
    public abstract void draw(Image image);
            
    public static final int LENGTH = 30;

    void setY(int y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

enum Direction{North, West, East, South};
