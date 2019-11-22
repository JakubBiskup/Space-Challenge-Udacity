package com.company;

public class Rocket implements SpaceShip{
    int cost;//in milions $
    int weight;//in kilograms
    int weightWithCargo=weight;//in kg
    int maxWeight;// in kg

    public boolean launch(){
        return true;
    }
    public boolean land(){
        return true;
    }
    public boolean canCarry(Item item){
        /**
         * @param item item to be loaded (or not) onto the rocket
         * @return true if the rocket can carry the item without exceeding the maximal weight
         */
        return item.weight<=this.maxWeight-this.weightWithCargo;
    }
    public void carry(Item item){
        /**
         * increases the rocket's weight by the item's weight
         * @param item item to be loaded onto the rocket
         */
        this.weightWithCargo+=item.weight;
    }
}
