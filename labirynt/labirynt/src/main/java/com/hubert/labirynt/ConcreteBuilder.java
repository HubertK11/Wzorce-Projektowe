/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hubert.labirynt;

/**
 *
 * @author student
 */
public class ConcreteBuilder implements MazeBuilder {

    private Maze maze;
    private MazeBomb mazeBomb;

    public ConcreteBuilder() {

    }

    @Override
    public void buildMaze() {
        maze = new Maze();
    }
    
    @Override
    public void buildMazeBomb() {
        mazeBomb = new MazeBomb();
    }

    @Override
    public void buildRoom(int nr, int x, int y) {
        Room room = new Room(nr, x, y);
        room.setSide(Direction.North, new Wall(Direction.North));
        room.setSide(Direction.East, new Wall(Direction.East));
        room.setSide(Direction.South, new Wall(Direction.South));
        room.setSide(Direction.West, new Wall(Direction.West));
        if (maze != null) {
            maze.addRoom(room);
        }
    }

    @Override
    public void buildDoor(int from, int to) {
        Room roomFrom = maze.getRoomByNumber(from); 
        Room roomTo = maze.getRoomByNumber(to); 
        Door door = new Door(roomFrom, roomTo);
        roomFrom.setSide(commonWall(roomFrom, roomTo), door);
        roomTo.setSide(commonWall(roomTo, roomFrom), door);
    }
    
    @Override
    public void buildRoomBomb(char bomb, int x, int y) {
        RoomBomb roomBomb = new RoomBomb(bomb, x, y);
        roomBomb.setSide(Direction.North, new Wall(Direction.North));
        roomBomb.setSide(Direction.East, new Wall(Direction.East));
        roomBomb.setSide(Direction.South, new Wall(Direction.South));
        roomBomb.setSide(Direction.West, new Wall(Direction.West));
        if (maze != null) {
            maze.addRoomBomb(roomBomb);
        }
    }

    @Override
    public Maze getMaze() {
        return maze;
    }

    private Direction commonWall(Room roomFrom, Room roomTo) {
        int x1 = roomFrom.getx();
        int y1 = roomFrom.gety();
        int x2 = roomTo.getx();
        int y2 = roomTo.gety();

        if (y1 != y2) {
            return y1 > y2 ? Direction.North : Direction.South;
        } else {
            return x1 > x2 ? Direction.West : Direction.East;
        }
    }

}
