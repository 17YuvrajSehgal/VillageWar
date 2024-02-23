package Utility;

import Models.Village;
import VillageElements.*;

import java.util.ArrayList;
import java.util.List;

public class UpgradeResearchLab {
    private static List<Builder> availableBuilders;
    private int nextAvailableBuilder = 0;

    public UpgradeResearchLab(){
        availableBuilders = new ArrayList<>();
    }

    public List<Builder> getAvailableBuilders() {
        return availableBuilders;
    }

    public void setAvailableBuilders(List<Builder> availableBuilders) {
        UpgradeResearchLab.availableBuilders = availableBuilders;
    }

    public void addBuilder(Builder builder){
        availableBuilders.add(builder);
    }

    private Builder getNextAvailableBuilder() throws DependentEntityUnavailable {
        for(int i=0; i<availableBuilders.size(); i++){
            Builder builder = availableBuilders.get(i);
            if(builder.isAvailable()){
                return builder;
            }
        }
        throw new DependentEntityUnavailable();
    }

    public void upgradeBuilding(Building building, int time) throws DependentEntityUnavailable, UpgradeCancelledDueToMaxedOutException {
        Builder builder = getNextAvailableBuilder();
        upgradeBuildingSync(building,builder, time);
    }
    private synchronized Building upgradeBuildingSync(Building building, Builder builder,int time)
            throws UpgradeCancelledDueToMaxedOutException, DependentEntityUnavailable{

        if(building.getLevel()>=building.getMaxLevel())
            throw new UpgradeCancelledDueToMaxedOutException();
        else if(availableBuilders.isEmpty())
            throw new DependentEntityUnavailable();

        builder.setAvailable(false);

        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        building.upgrade();
        builder.setAvailable(true);

        System.out.println("Building upgrade finshed: "+building);
        return building;
    }
}
