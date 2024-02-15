/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hubert.labirynt;

import java.awt.Image;


public class MazeGame {

    private Maze maze;
    private MazeBomb mazeBomb;
    private int x, y;

    /**
     * Tworzenie labiryntu przy pomocy wzorca budowniczy
     * @param x
     * @param y
     * @param builder
     * @return
     */
    public Maze createMaze(int x, int y, MazeBuilder builder) {
        builder.buildMaze();
        builder.buildMazeBomb();
        builder.buildRoom(1, x, y);
        builder.buildRoom(2, x, y + MapSite.LENGTH);
        builder.buildDoor(1, 2);
        builder.buildRoom(3, x + MapSite.LENGTH, y);
        builder.buildRoom(4, x + MapSite.LENGTH, y + MapSite.LENGTH);
        builder.buildDoor(2, 4);
        builder.buildDoor(3, 4);
        builder.buildDoor(1, 3);
        builder.buildRoom(5, x + MapSite.LENGTH * 2, y);
        builder.buildDoor(3, 5);
        builder.buildRoom(6, x + MapSite.LENGTH, y + MapSite.LENGTH * 2);
        builder.buildDoor(4, 6);
        builder.buildRoomBomb('B',x + MapSite.LENGTH, y + MapSite.LENGTH * 3);

        // Dodanie kolejnych pokoi
        for (int i = 7; i <= 16; i++) {
            builder.buildRoom(i, x + MapSite.LENGTH * (i - 3), y + MapSite.LENGTH * (i - 2));
            if (i % 2 == 0) {
                builder.buildDoor(i - 1, i);
            }
        }

        return builder.getMaze();
    }

    /**
     * Pierwszy sposob budowy labiryntu
     *
     * @param x
     * @param y
     * @return
     */
    public Maze createMaze(int x, int y) {
        int roomNr = 1;
        maze = new Maze();

        Room room1 = new Room(roomNr++, x, y);
        Room room2 = new Room(roomNr++, x, y + MapSite.LENGTH);
        Door door1 = new Door(room1, room2);
        Room room3 = new Room(roomNr++, x, y + MapSite.LENGTH * 2);
        Door door2 = new Door(room2, room3);
        Room room4 = new Room(roomNr++, x, y + MapSite.LENGTH * 3);
        Door door3 = new Door(room3, room4);
        Room room5 = new Room(roomNr++, x + MapSite.LENGTH, y);
        Door door4 = new Door(room1, room5);
        Room room6 = new Room(roomNr++, x + MapSite.LENGTH, y + MapSite.LENGTH);
        Room room7 = new Room(roomNr++, x + MapSite.LENGTH, y + MapSite.LENGTH * 2);
        Room room8 = new Room(roomNr++, x + MapSite.LENGTH * 2, y);
        Room room9 = new Room(roomNr++, x + MapSite.LENGTH * 2, y + MapSite.LENGTH);
        Door door5 = new Door(room8, room9);
        Room room10 = new Room(roomNr++, x + MapSite.LENGTH * 2, y + MapSite.LENGTH * 2);
        Door door6 = new Door(room9, room10);
        Room room11 = new Room(roomNr++, x + MapSite.LENGTH * 3, y);
        Room room12 = new Room(roomNr++, x + MapSite.LENGTH * 3, y + MapSite.LENGTH);
        Room room13 = new Room(roomNr++, x + MapSite.LENGTH * 3, y + MapSite.LENGTH * 2);
        Room room14 = new Room(roomNr++, x + MapSite.LENGTH * 4, y);
        Room room15 = new Room(roomNr++, x + MapSite.LENGTH * 4, y + MapSite.LENGTH);
        Door door7 = new Door(room14, room15);
        Room room16 = new Room(roomNr++, x + MapSite.LENGTH * 4, y + MapSite.LENGTH * 2);
        Room room17 = new Room(roomNr++, x + MapSite.LENGTH * 5, y);
        Room room18 = new Room(roomNr++, x + MapSite.LENGTH * 5, y + MapSite.LENGTH);
        Door door8 = new Door(room17, room18);
        Room room19 = new Room(roomNr++, x + MapSite.LENGTH * 5, y + MapSite.LENGTH * 2);
        Door door9 = new Door(room18, room19);
        Room room20 = new Room(roomNr++, x + MapSite.LENGTH * 5, y + MapSite.LENGTH * 3);
        Door door10 = new Door(room19, room20);
        Door door11 = new Door(room20, room20);
        Door door12 = new Door(room15, room16);
        Door door13 = new Door(room5, room8);
        Door door14 = new Door(room8, room11);
        Door door15 = new Door(room11, room14);
        Door door16 = new Door(room14, room17);
        Door door17 = new Door(room10, room13);

        room1.setSide(Direction.North, new Wall(Direction.North));
        room1.setSide(Direction.East, door4);
        room1.setSide(Direction.South, door1);
        room1.setSide(Direction.West, new Wall(Direction.West));

        room2.setSide(Direction.North, door1);
        room2.setSide(Direction.East, new Wall(Direction.East));
        room2.setSide(Direction.South, door2);
        room2.setSide(Direction.West, new Wall(Direction.West));

        room3.setSide(Direction.North, door2);
        room3.setSide(Direction.East, new Wall(Direction.East));
        room3.setSide(Direction.South, door3);
        room3.setSide(Direction.West, new Wall(Direction.West));

        room4.setSide(Direction.North, door3);
        room4.setSide(Direction.East, new Wall(Direction.East));
        room4.setSide(Direction.South, door3);
        room4.setSide(Direction.West, new Wall(Direction.West));

        room5.setSide(Direction.North, new Wall(Direction.North));
        room5.setSide(Direction.East, door1);
        room5.setSide(Direction.South, new Wall(Direction.South));
        room5.setSide(Direction.West, door4);

        room6.setSide(Direction.North, new Wall(Direction.North));
        room6.setSide(Direction.East, new Wall(Direction.East));
        room6.setSide(Direction.South, new Wall(Direction.South));
        room6.setSide(Direction.West, new Wall(Direction.West));

        room7.setSide(Direction.North, new Wall(Direction.North));
        room7.setSide(Direction.East, new Wall(Direction.East));
        room7.setSide(Direction.South, new Wall(Direction.South));
        room7.setSide(Direction.West, new Wall(Direction.West));

        room8.setSide(Direction.North, new Wall(Direction.North));
        room8.setSide(Direction.East, door1);
        room8.setSide(Direction.South, door5);
        room8.setSide(Direction.West, door13);

        room9.setSide(Direction.North, door5);
        room9.setSide(Direction.East, door1);
        room9.setSide(Direction.South, door6);
        room9.setSide(Direction.West, new Wall(Direction.West));

        room10.setSide(Direction.North, door6);
        room10.setSide(Direction.East, new Wall(Direction.East));
        room10.setSide(Direction.South, new Wall(Direction.South));
        room10.setSide(Direction.West, new Wall(Direction.West));

        room11.setSide(Direction.North, new Wall(Direction.North));
        room11.setSide(Direction.East, door1);
        room11.setSide(Direction.South, new Wall(Direction.South));
        room11.setSide(Direction.West, door14);

        room12.setSide(Direction.North, new Wall(Direction.North));
        room12.setSide(Direction.East, door1);
        room12.setSide(Direction.South, new Wall(Direction.South));
        room12.setSide(Direction.West, new Wall(Direction.West));

        room13.setSide(Direction.North, new Wall(Direction.North));
        room13.setSide(Direction.East, new Wall(Direction.East));
        room13.setSide(Direction.South, new Wall(Direction.South));
        room13.setSide(Direction.West, new Wall(Direction.West));

        room14.setSide(Direction.North, new Wall(Direction.North));
        room14.setSide(Direction.East, door1);
        room14.setSide(Direction.South, door7);
        room14.setSide(Direction.West, door15);

        room15.setSide(Direction.North, door7);
        room15.setSide(Direction.East, new Wall(Direction.East));
        room15.setSide(Direction.South, door12);
        room15.setSide(Direction.West, new Wall(Direction.West));

        room16.setSide(Direction.North, door12);
        room16.setSide(Direction.East, new Wall(Direction.East));
        room16.setSide(Direction.South, new Wall(Direction.South));
        room16.setSide(Direction.West, new Wall(Direction.West));

        room17.setSide(Direction.North, new Wall(Direction.North));
        room17.setSide(Direction.East, new Wall(Direction.East));
        room17.setSide(Direction.South, door8);
        room17.setSide(Direction.West, door16);

        room18.setSide(Direction.North, door8);
        room18.setSide(Direction.East, new Wall(Direction.East));
        room18.setSide(Direction.South, door9);
        room18.setSide(Direction.West, new Wall(Direction.West));

        room19.setSide(Direction.North, door9);
        room19.setSide(Direction.East, new Wall(Direction.East));
        room19.setSide(Direction.South, door10);
        room19.setSide(Direction.West, new Wall(Direction.West));

        room20.setSide(Direction.North, door10);
        room20.setSide(Direction.East, new Wall(Direction.East));
        room20.setSide(Direction.South, door11);
        room20.setSide(Direction.West, new Wall(Direction.West));

        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);
        maze.addRoom(room5);
        maze.addRoom(room6);
        maze.addRoom(room7);
        maze.addRoom(room8);
        maze.addRoom(room9);
        maze.addRoom(room10);
        maze.addRoom(room11);
        maze.addRoom(room12);
        maze.addRoom(room13);
        maze.addRoom(room14);
        maze.addRoom(room15);
        maze.addRoom(room16);
        maze.addRoom(room17);
        maze.addRoom(room18);
        maze.addRoom(room19);
        maze.addRoom(room20);

        return maze;
    }

}

