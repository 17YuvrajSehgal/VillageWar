package ConcurrentAbstractFactory;

import VillageElements.*;

/**
 * This class represents a factory that helps in the production of attacking entity objects
 */
public class BuildingFactoryConcurrent implements AbstractFactoryConcurrent, Runnable {

    public static final String ARCHER_TOWER = "ARCHER TOWER";
    public static final String CANNON = "CANNON";
    public static final String CATAPULT = "CATAPULT";
    public static final String FARM = "FARM";
    public static final String GOLD_MINE = "GOLD MINE";
    public static final String IRON_MINE = "IRON MINE";
    public static final String LUMBER_MILL = "LUMBER MILL";

    private final String buildingType;
    private VillageEntity villageEntity;

    public BuildingFactoryConcurrent(String buildingType) {
        this.buildingType= buildingType;
    }

    @Override
    public void run() {
        switch (buildingType.toUpperCase()) {
            case "ARCHER TOWER" -> villageEntity = new ArcherTower();
            case "CANNON" -> villageEntity = new Cannon();
            case "CATAPULT" -> villageEntity = new Catapult();
            case "FARM" -> villageEntity = new Farm();
            case "GOLD MINE" -> villageEntity = new GoldMine();
            case "IRON MINE" -> villageEntity = new IronMine();
            case "LUMBER MILL" -> villageEntity = new LumberMill();
            default -> villageEntity=null;
        }
    }

    public Building getBuilding(){
        return (Building) villageEntity;
    }

    @Override
    public VillageEntity getVillageEntity(String buildingType){
        Thread thread = new Thread(this);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return villageEntity;
    }
}

