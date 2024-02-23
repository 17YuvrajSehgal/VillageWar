/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChallengeDecision;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robson
 */
public class ChallengeEntitySet <T extends Number, V extends Number> {
    List<ChallengeAttack<T,V>> entityAttackList;
    List<ChallengeDefense<T,V>> entityDefenseList;
    List<ChallengeResource<T,V>> entityResourceList;
    
    public ChallengeEntitySet( List<ChallengeAttack<T,V>> entityAttackList, List<ChallengeDefense<T,V>> entityDefenseList,
                               List<ChallengeResource<T,V>> entityResourceList ) {
        this.entityAttackList = entityAttackList;
        this.entityDefenseList = entityDefenseList;
        this.entityResourceList = entityResourceList;
    }
    
    public ChallengeEntitySet() {
        entityAttackList = new ArrayList();
        entityDefenseList = new ArrayList();
        entityResourceList = new ArrayList();
    }
    
    public void setEntityAttackList( List<ChallengeAttack<T,V>> entityAttackList ) {
        this.entityAttackList = entityAttackList;

    }

    public void setEntityDefenseList( List<ChallengeDefense<T,V>> entityDefenseList ) {
        this.entityDefenseList = entityDefenseList;
    }

    public void setEntityResourceList( List<ChallengeResource<T,V>> entityResourceList ) {
        this.entityResourceList = entityResourceList;
    }
   
    public List<ChallengeAttack<T,V>> getEntityAttackList(){
        return this.entityAttackList;
    }

    public List<ChallengeDefense<T,V>> getEntityDefenseList(){
        return this.entityDefenseList;
    }

    public List<ChallengeResource<T,V>> getEntityResourceList(){
        return this.entityResourceList;
    }
}
