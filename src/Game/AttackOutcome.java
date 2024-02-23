package Game;

import VillageElements.CollectedResources;

public class AttackOutcome {
    CollectedResources loot;
    boolean success;


    public AttackOutcome(boolean success, CollectedResources loot) {
        this.loot=loot;
        this.success=success;
    }


    @Override
    public String toString() {
        return "AttackOutcome{" +
                "loot=" + loot +
                ", success=" + success +
                '}';
    }
}
