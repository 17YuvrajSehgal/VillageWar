package AbstractFactory;

import ConcurrentAbstractFactory.InvalidFactoryTypeException;

/**
 * This class returns the factory of the given type.
 */
 public class FactoryProducer {
    public static final String NATURAL_RESOURCES= "NATURAL RESOURCES";
    public static final String DEFENCE= "DEFENCE";
    public static final String WORKER= "WORKER";
    public static final String EXHAUSTIBLE_NATURAL_RESOURCE= "EXHAUSTIBLE NATURAL RESOURCES";
    public static final String BUILDING= "BUILDING";


     /**
      * This method returns the factory of the given type.
      * @param factoryType Type of factory
      * @return factory of the given type.
      * @throws InvalidFactoryTypeException throws runtime exception if name does not match required entity
      */
    public static AbstractFactory getFactory(String factoryType) throws InvalidFactoryTypeException {
        return switch (factoryType.toUpperCase()) {
            case "NATURAL RESOURCES" -> new NaturalResourcesFactory();
            case "WORKER" -> new WorkerFactory();
            case "DEFENCE" -> new AttackFactory();
            case "BUILDING" -> new BuildingFactory();
            default -> throw new InvalidFactoryTypeException();
        };
    }
}
