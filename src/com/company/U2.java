package com.company;

public class U2 extends Rocket {
    U2(){
        this.weight=18000;
        this.cost=120;
        this.maxWeight=29000;
    }
    public boolean launch(){
        double randomNumber=Math.random();
        int cargoCarried=this.weightWithCargo-this.weight;
        int cargoLimit=this.maxWeight-this.weight;
        double cargoFactor=1.0*cargoCarried/cargoLimit;
        return randomNumber >= 0.04 * cargoFactor;
    }
    public boolean land(){
        double randomNumber=Math.random();
        int cargoCarried=this.weightWithCargo-this.weight;
        int cargoLimit=this.maxWeight-this.weight;
        double cargoFactor=1.0*cargoCarried/cargoLimit;
        return randomNumber >= 0.08 * cargoFactor;
    }
}
