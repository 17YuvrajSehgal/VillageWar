package ConcurrentAbstractFactory;

import VillageElements.VillageEntity;

/**
 * This class represents an abstract factory that produces village entities.
 */
public interface AbstractFactoryConcurrent extends Runnable {
    /**
     * This method returns the village entity object of the specified name
     * @param entityName Name of the entity as specified in class
     * @return Village entity object
     * @throws InvalidVillageEntityTypeException throws runtime exception if name does not match required entity
     */
    VillageEntity getVillageEntity(String entityName) throws InvalidVillageEntityTypeException;
}
