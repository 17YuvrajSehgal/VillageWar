package VillageElements;

import java.io.Serializable;

/**
 * This error is thrown when some entity depends on other entity, but it gets unavailable
 */
public class DependentEntityUnavailable extends Exception implements Serializable {
}
