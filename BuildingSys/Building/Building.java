package Building;

import java.util.ArrayList;

public abstract class Building {
    private int id;
    private ArrayList<Room> rooms;

    public Building(int id, int noOfRooms) {
        this.id = id;
        rooms = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    // my custom
    public void setRooms(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Room addRoom(double length, double width) {
        Room myRoom = new Room(length, width);
        rooms.add(myRoom);
        return myRoom;
    }

    public void modifyRoom(int roomNo, double length, double width) {
        rooms.get(roomNo-1).setLength(length);
        rooms.get(roomNo-1).setWidth(width);
    }

    public void deleteRoom(int roomNo) {
        rooms.remove(roomNo-1);
    }

    public void printRooms() {
        for (int x = 0; x < rooms.size(); x++)
            System.out.println("Room No.: " + (x + 1) +  ", " + rooms.get(x));
    }

    public int getRoomQty() {
        return rooms.size();
    }

    abstract public void modifyBuilding();

    abstract public void printBuilding();

}
