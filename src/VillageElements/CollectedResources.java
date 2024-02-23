package VillageElements;

import java.io.Serializable;

/**
 * This class represents the treasury of the village or any cost of entity. As the treasury and cost is a combination
 * of lumber, iron and gold, so this Cost object represents all three values as a single entity.
 */
public class CollectedResources implements Comparable<CollectedResources>, Serializable {

    //instance variables
    private int lumber, iron, gold; //amount of lumber, iron and gold

    /**
     * Class constructor to initialize the values of lumber, iron and gold respectively
     * @param lumber amount of lumber
     * @param iron amount of iron
     * @param gold amount of gold
     */
    public CollectedResources(int lumber, int iron, int gold) {
        this.lumber = lumber;
        this.iron = iron;
        this.gold = gold;
    }

    /**
     * Class constructor
     */
    public CollectedResources(){
        this(0,0,0);
    }

    /**
     * Returns the amount of lumber
     * @return amount of lumber
     */
    public int getLumber() {
        return lumber;
    }

    /**
     * Sets the amount of lumber
     * @param lumber amount of lumber
     */
    public void setLumber(int lumber) {
        this.lumber = lumber;
    }

    /**
     * Returns the amount of iron
     * @return amount of iron
     */
    public int getIron() {
        return iron;
    }

    /**
     * Sets the amount of iron
     * @param iron amount of iron
     */
    public void setIron(int iron) {
        this.iron = iron;
    }

    /**
     * Returns the amount of gold
     * @return amount of gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * Sets the amount of gold
     * @param gold amount of gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }


    /**
     * Returns the string representation of the object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return "CollectedResources{" +
                "lumber=" + lumber +
                ", iron=" + iron +
                ", gold=" + gold +
                '}';
    }

    @Override
    public int compareTo(CollectedResources cost2) {
        if(cost2.gold==this.gold && cost2.iron==this.iron && cost2.lumber==this.lumber) return 0;
        else if(cost2.gold>this.gold || cost2.iron>this.iron || cost2.lumber>this.lumber) return -1;
        else return 1;
    }

    public CollectedResources subCost(CollectedResources cost){
        this.lumber-=cost.lumber;
        this.iron-=cost.iron;
        this.gold-=cost.gold;
        return new CollectedResources(this.getLumber(),this.getIron(),this.getGold());
    }

    public CollectedResources addCost(CollectedResources cost){
        this.lumber+=cost.lumber;
        this.iron+=cost.iron;
        this.gold+=cost.gold;
        return new CollectedResources(this.getLumber(),this.getIron(),this.getGold());

    }
}
