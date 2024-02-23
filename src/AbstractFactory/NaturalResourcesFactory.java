package AbstractFactory;

import ConcurrentAbstractFactory.InvalidNaturalResourcesExceptionTypeException;
import VillageElements.*;

/**
 * This class represents a factory that helps in the production of natural resources entity objects
 */
public class NaturalResourcesFactory implements AbstractFactory {
    public static final String LUMBER_MILL= "LUMBER MILL";
    public static final String GOLD_MINE= "FARM";
    public static final String FARM= "IRON MINE";
    public static final String IRON_MINE = "GOLD MINE";

    /**
     * Returns the attacking village entity
     * @param naturalResourceType Name of the entity as specified in the implementing factory
     * @return Object of given natural resource entity
     */
    @Override
    public VillageEntity getVillageEntity(String naturalResourceType) throws InvalidNaturalResourcesExceptionTypeException {
        return switch (naturalResourceType.toUpperCase()) {
            case "LUMBER MILL" -> new LumberMill();
            case "FARM" -> new Farm();
            case "IRON MINE" -> new IronMine();
            case "GOLD MINE" -> new GoldMine();
            default -> throw new InvalidNaturalResourcesExceptionTypeException();
        };
    }
}