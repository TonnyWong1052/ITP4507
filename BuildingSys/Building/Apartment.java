package Building;
public class Apartment extends Building {
    private double monthlyRental;
    private String supportStaff;

    public Apartment(int id, int noOfRooms, double monthlyRental, String supportStaff){
        super(id, noOfRooms);
        this.monthlyRental = monthlyRental;
        this.supportStaff = supportStaff;    
    }

    public void setMonthlyRental(double monthlyRental){
        this.monthlyRental = monthlyRental;
    }

    public double getMonthlyRental(){
        return monthlyRental;
    }

    public void setSupportStaff(String suppoStaff){
        this.supportStaff = suppoStaff;
    }

    public String getSupportStaff(){
        return supportStaff;
    } 

    public void modifyBuilding(){
        //
    }

    public void printBuilding(){
        System.out.println("Building No: " + getId());
        System.out.println("Support Staff: " + getSupportStaff());
        System.out.println("Monthly Rental: " + getMonthlyRental());
        printRooms();
    }

    @Override
    public String toString(){
        String Message = "Building No.: " + getId() + 
                    ", Support Staff: " + getSupportStaff() +
                    ", Monthly Rental: " + getMonthlyRental();
        return Message;
    }
}
