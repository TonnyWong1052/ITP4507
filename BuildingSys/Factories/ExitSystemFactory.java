package Factories;

public class ExitSystemFactory implements CommandFactory {

    @Override
    public void create() {
        //shut down system 
        System.exit(0);
    }

}