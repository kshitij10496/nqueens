/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueens;

/**
 *
 * @author kshitij10496
 */
public class Queens {
    
    private final int[] locations;
        
    public Queens(int n) {
    
        locations = new int[n];
    }

    public void setQueen(int i, int val){
    
        this.locations[i] = val;
    }
    
    public int getQueen(int i) {
    
        return this.locations[i];
    }
    
    public int length(){
        
        return this.locations.length;
    
    }
}
