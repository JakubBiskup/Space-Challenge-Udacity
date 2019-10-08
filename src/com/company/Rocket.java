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
        return item.weight<=this.maxWeight-this.weightWithCargo;
    }
    public void carry(Item item){
        this.weightWithCargo+=item.weight;
    }
}
