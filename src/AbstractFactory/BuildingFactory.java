package AbstractFactory;

import VillageElements.*;

/**
 * This class represents a factory that helps in the production of attacking entity objects
 */
public class BuildingFactory implements AbstractFactory {

    public static final String ARCHER_TOWER = "ARCHER TOWER";
    public static final String CANNON = "CANNON";
    public static final String CATAPULT = "CATAPULT";
    public static final String FARM = "FARM";
    public static final String GOLD_MINE = "GOLD MINE";
    public static final String IRON_MINE = "IRON MINE";
    public static final String LUMBER_MILL = "LUMBER MILL";

    /**
     *
     * @param exhaustibleResourceType Name of the building as specified in class
     * Returns object of specified building entity
     */
    @Override
    public VillageEntity getVillageEntity(String exhaustibleResourceType) throws InvalidBuildingTypeExceptionTypeException {
        return switch (exhaustibleResourceType.toUpperCase()) {
            case "ARCHER TOWER" -> new ArcherTower();
            case "CANNON" -> new Cannon();
            case "CATAPULT" -> new Catapult();
            case "FARM" -> new Farm();
            case "GOLD MINE" -> new GoldMine();
            case "IRON MINE" -> new IronMine();
            case "LUMBER MILL" -> new LumberMill();
            default -> throw new InvalidBuildingTypeExceptionTypeException();
        };
    }
}
