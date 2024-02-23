package concurrency;

import Controllers.VillageController;
import Models.Village;
import Views.VillageView;

import java.io.Serializable;

/**
 * This class is a village controller generator class that creates new instance of Village Controller concurrently
 */
public class VillageControllerGenerator implements Runnable, Serializable {
    private VillageController villageController;
    private static int count = 0;
    private final int id;

    public VillageControllerGenerator() {
        id = ++count;
    }

    public VillageController getVillageController(){
        return villageController;
    }

    @Override
    public void run() {
        this.villageController = new VillageController(new Village(),new VillageView());
        System.out.println("id: "+id+" Village: "+villageController);
    }
}
