package Memento;

import Building.Apartment;
import Command.Command;

public class ApartmentMemento extends BuildingMemento {
    private double monthlyRental;
    private String supportStaff;

    public ApartmentMemento(Command myCommand, Apartment building) {
        super(myCommand, building);
        this.monthlyRental = building.getMonthlyRental();
        this.supportStaff = building.getSupportStaff();
    }

    @Override
    public void restore() {
        ((Apartment) myBuilding).setMonthlyRental(monthlyRental);
        ((Apartment) myBuilding).setSupportStaff(supportStaff);
        restoreRooms(myBuilding);
    }

}
