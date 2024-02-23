/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChallengeDecision;

/**
 *
 * @author robson
 * @param <T>
 */
public class ChallengeDefense <T extends Number, V extends Number> extends ChallengeEntity<T,V> {
    T defense;
    V hit;
    
    public ChallengeDefense( T defense ) {
        this.defense = defense;
    }
    
    public ChallengeDefense( T defense, V hit ) {
        this.defense = defense;
        this.hit = hit;
    }
    
    @Override
    public T getProperty() {
        return this.defense;
    }
    
    @Override
    public void setProperty( T defense ) {
        this.defense = defense;
    }

    @Override
    public V getHitPoints() {
        return hit;
    }
    
    @Override
    public void setHitPoints( V value ) {
        hit = value;
    }

    @Override
    public int compare( ChallengeEntity ce ) {
        double result;
        result = this.defense.doubleValue() - ce.getProperty().doubleValue();
        
        if ( result == 0 ) 
            return 0;
        else if ( result > 0 ) 
            return 1;
        else return -1;
    }

    @Override
    public double checkDifference( ChallengeEntity ce ) {
        return this.defense.doubleValue() - ce.getProperty().doubleValue();
    }

    @Override
    public FightResult fight(ChallengeEntity<T, V> ce) {
        return new FightResult( false, new ChallengeDefense( 0 ) );
    }


    @Override
    public String toString() {
        return "ChallengeDefense{" +
                "defense=" + defense +
                ", hit=" + hit +
                '}';
    }
}
