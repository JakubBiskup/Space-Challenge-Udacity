package com.company;

public class U1 extends Rocket {
    U1(){
        this.weight=10000;
        this.cost=100;
        this.maxWeight=18000;
        this.weightWithCargo=this.weight;
    }
    public boolean launch(){
        /**
         * @return whether launch was successful or not (false means the rocket crashed during the launch)
         */
        double randomNumber=Math.random();
        int cargoCarried=this.weightWithCargo-this.weight;
        int cargoLimit=this.maxWeight-this.weight;
        double cargoFactor=1.0*cargoCarried/cargoLimit;
        return randomNumber >= 0.05 * cargoFactor;
    }
    public boolean land(){
        /**
         * @return whether landing was successful or not (false means the rocket crashed during the landing)
         */
        double randomNumber=Math.random();
        int cargoCarried=this.weightWithCargo-this.weight;
        int cargoLimit=this.maxWeight-this.weight;
        double cargoFactor=1.0*cargoCarried/cargoLimit;
        return randomNumber >= 0.01 * cargoFactor;
    }
}
