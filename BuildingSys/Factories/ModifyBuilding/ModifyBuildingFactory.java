package Factories.ModifyBuilding;

import java.util.ArrayList;
import java.util.Scanner;

import Building.Apartment;
import Building.Building;
import Building.House;
import Factories.CommandFactory;
import Main.BuildingSys;
import Memento.Caretaker;

public class ModifyBuildingFactory implements CommandFactory {
    protected ArrayList<Building> buildingRecord;
    protected Scanner sc;
    protected int buildingId;
    protected Caretaker caretaker;
    protected Building myBuilding;

    public ModifyBuildingFactory(ArrayList<Building> buildingRecord, Caretaker caretaker) {
        this.buildingRecord = buildingRecord;
        this.sc = BuildingSys.sc;
        this.caretaker = caretaker;
    }

    
    public void create() throws Exception {
        System.out.print("Building No.: ");
        buildingId = sc.nextInt();

        // check id is exist, if not existed, return it
        int size = buildingRecord.stream().filter(x -> x.getId() == buildingId).toList().size();
        if (size == 0) {
            System.out.println("The building no. is not existed");
            return;
        }

        myBuilding = buildingRecord.stream().filter(x -> x.getId() == buildingId).findFirst().get();

        // check building id is exist or not
        if (buildingRecord.stream().filter(x -> x.getId() == buildingId).count() == 0) {
            System.out.println("The building no. does exist!");
            return;
        } else {
            System.out.println(myBuilding);
            // accroding the type of building, then go to different building factory to save
            // building to buildingRecord
            if (myBuilding instanceof Apartment) 
                new ModifyApartmentFactory(buildingRecord, caretaker, buildingId, myBuilding).create();
            else if (myBuilding instanceof House)
                new ModifyHouseFactory(buildingRecord, caretaker, buildingId, myBuilding).create();
            else {
                // something error handle, if add any new building object, can add here
                System.out.println("System error");
                return;
            }
        }
    }

    protected void printUpdateBuilding() {
        System.out.println("Building is modified:");
        System.out.println(myBuilding);
    }
}
