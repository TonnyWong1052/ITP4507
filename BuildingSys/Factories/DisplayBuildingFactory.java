package Factories;

import java.util.ArrayList;
import java.util.Scanner;

import Building.Building;
import Command.DisplayAllBuildingCommand;
import Command.DisplayBuildingCommand;

public class DisplayBuildingFactory implements CommandFactory {
    private Scanner sc;
    private ArrayList<Building> buildingRecord;

    public DisplayBuildingFactory(ArrayList<Building> buildingRecord) {
        this.buildingRecord = buildingRecord;
        this.sc = Main.BuildingSys.sc;
    }

    @Override
    public void create() throws Exception {
        System.out.println("Enter Building No.(* to display all):");
        String command = sc.next();
        
        if(command.equals("*"))
            new DisplayAllBuildingCommand(buildingRecord).execute();
        else
            new DisplayBuildingCommand(buildingRecord, Integer.parseInt(command)).execute();
    }
    
}
