/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hubert.labirynt;
import java.awt.Graphics;
import java.awt.Image;


public class Wall extends MapSite {
    
    private Direction direction;
    
    private int x;
    private int y;
    
        public void setX(int newx)
        {
            this.x = newx;
        }
        
    public void setY(int newy)
        {
            this.y = newy;
        } 
    
    public Wall(Direction d){
        
        direction = d;
    }
     
    public void enter() {  
    }
    
    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        
        switch (direction)
        {
            case North:
            case South:
                
                g.drawLine(x, y, x + MapSite.LENGTH, y); //pozioma
                
            break;
            default:
                
                g.drawLine(x , y, x, y + MapSite.LENGTH); //pionowa
                
        }
        
        /*int x = 30;
        int y = 50;
        int a = 60;
        int b = 80;
        
        for (int i = 0; i < 2; i++)
        {
            g.drawLine(x, y, x + MapSite.LENGTH, y); //górna poziom
     
            g.drawLine(x, y, x, y+MapSite.LENGTH); //lewy bok
        
            g.drawLine(x + MapSite.LENGTH, y, x + MapSite.LENGTH, y + MapSite.LENGTH); //prawy bok 
            g.drawLine(x, y + MapSite.LENGTH, x + MapSite.LENGTH, y + MapSite.LENGTH); //dolny poziom
            x += 30;
        }
        //Nowy kwadrat
        for (int i =0; i < 10; i++)
        {
            a += 30;
            g.drawLine(a, b, a + MapSite.LENGTH, b); //dolna poziom
     
            g.drawLine(a, y, a, y + MapSite.LENGTH); //lewy bok
        
            g.drawLine(a + MapSite.LENGTH, b, a + MapSite.LENGTH, y); //prawy bok 
            g.drawLine(a, y, a + MapSite.LENGTH, y); //gorny poziom
        }*/
    }
    
}

