/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChallengeDecision;

/**
 *
 * @author robson
 */
class FightResult {
    Boolean result;
    ChallengeEntity<Double, Double> ce;
    
    public FightResult( Boolean result, ChallengeEntity ce ) {
        this.result = result;
        this.ce = ce;
    }

    public Boolean getResult() {
        return this.result;
    }
    
    public ChallengeEntity<Double, Double> getChallengeEntity() {
        return ce;
    }


    @Override
    public String toString() {
        return "FightResult{" +
                "result=" + result +
                ", ce=" + ce +
                '}';
    }
}
