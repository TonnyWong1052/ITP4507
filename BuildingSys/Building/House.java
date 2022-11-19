package Building;
public class House extends Building{
    private int noOfFloors;

    public House(int id, int noOfRooms, int noOfFloors){
        super(id, noOfRooms);
        this.noOfFloors = noOfFloors;
    }

    public void setFloors(int noOfFloors){
        this.noOfFloors = noOfFloors;
    }

    public int getFloors(){
        return noOfFloors;
    }

    @Override
    public void modifyBuilding() {
        //
    }

    @Override
    public void printBuilding() {
        System.out.println("Building No: " + getId());
        System.out.println("No of Floors: " + getFloors());
        printRooms();
    }

    @Override
    public String toString() {
        String Message = "Building No.: " + getId() +
                        ", No. of Floors: " + getFloors();
        return Message;
    }
}
