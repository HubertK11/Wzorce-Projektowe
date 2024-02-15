/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hubert.labirynt;

/**
 *
 * @author student
 */
public interface MazeBuilder {
    void buildMazeBomb();
    void buildMaze();
    void buildRoom(int nr, int x, int y);
    void buildRoomBomb(char bomb, int x, int y);
    void buildDoor(int roomFrom, int roomTo);
    Maze getMaze();
}
