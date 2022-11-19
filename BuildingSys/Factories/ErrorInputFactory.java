package Factories;


public class ErrorInputFactory implements CommandFactory {

    @Override
    public void create() throws Exception {
        System.out.println("The number/command was not existed or unable, please try again!");
    }

}
