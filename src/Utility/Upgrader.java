package Utility;

import VillageElements.Building;
import VillageElements.DependentEntityUnavailable;
import VillageElements.UpgradeCancelledDueToMaxedOutException;
import VillageElements.VillageEntity;

public class Upgrader implements Runnable{

    UpgradeResearchLab upgradeResearchLab;
    VillageEntity villageEntity;
    int time;

    public Upgrader(UpgradeResearchLab upgradeResearchLab, VillageEntity villageEntity, int time){
        this.upgradeResearchLab=upgradeResearchLab;
        this.villageEntity=villageEntity;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            upgradeResearchLab.upgradeBuilding((Building) this.villageEntity,time);
        } catch (DependentEntityUnavailable | UpgradeCancelledDueToMaxedOutException e) {
            throw new RuntimeException(e);
        }
    }
}
