package VillageElements;

import java.io.Serializable;

/**
 * If some entity's level is more than the max level this error is thrown
 */
public class UpgradeCancelledDueToMaxedOutException extends Exception implements Serializable {
}
