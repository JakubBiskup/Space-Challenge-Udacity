package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        File phase1 = new File("Phase 1.txt");
        File phase2 = new File("Phase 2.txt");
        Simulation simulation = new Simulation(); //unnecessary but it's one of the steps in specs
        ArrayList<Item> items1 = Simulation.loadItems(phase1);
        ArrayList<Item> items2 = Simulation.loadItems(phase2);
        ArrayList<U1> u1fleet1 = Simulation.loadU1(items1);
        ArrayList<U1> u1fleet2 = Simulation.loadU1(items2);
        ArrayList<Item> items1b = Simulation.loadItems(phase1);
        ArrayList<Item> items2b = Simulation.loadItems(phase2);
        ArrayList<U2> u2fleet1 = Simulation.loadU2(items1b);
        ArrayList<U2> u2fleet2 = Simulation.loadU2(items2b);
        int budgetPhase1U1=Simulation.runSimulation(u1fleet1);
        int budgetPhase2U1=Simulation.runSimulation(u1fleet2);
        System.out.println("Total budget required using U1 rockets: "+(budgetPhase1U1+budgetPhase2U1)+" $Millions");
        int budgetPhase1U2=Simulation.runSimulation(u2fleet1);
        int budgetPhase2U2=Simulation.runSimulation(u2fleet2);
        System.out.println("Total budget required using U2 rockets: "+(budgetPhase1U2+budgetPhase2U2)+" $Millions");



    }
}
