package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public static ArrayList<Item> loadItems(File textfile) throws Exception{
        /**
         * Loads all items from a text file
         * @param textfile text file containing the list of items where each line in the text file consists of the item name followed by '='
         * @return an ArrayList of Item objects
         */
        ArrayList<Item> itemList = new ArrayList<Item>();
        Scanner scanner=new Scanner(textfile);
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            String[] splitLine=line.split("=");
            Item item=new Item(splitLine[0],Integer.parseInt(splitLine[1]));
            itemList.add(item);
        }
        return itemList;
    }
    public static ArrayList<U1> loadU1(ArrayList<Item> itemList){
        /**
         * starts creating U1 rockets. It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and filling that one until all items are loaded.
         * @param itemList an ArrayList of Item objects
         * @return an ArrayList of U1 rockets that together carry all items from the itemList
         */
        ArrayList<U1> monofleet= new ArrayList<U1>();
        while (itemList.size()>0){
            U1 u1Rocket= new U1();
            for (int i=itemList.size()-1;i>=0;i--){
                if (u1Rocket.canCarry(itemList.get(i))){
                    u1Rocket.carry(itemList.get(i));
                    itemList.remove(i);
                }
            }
            monofleet.add(u1Rocket);
        }
        return monofleet;
    }

    public static ArrayList<U2> loadU2(ArrayList<Item> itemList){
        /**
         * starts creating U2 rockets. It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and filling that one until all items are loaded.
         * @param itemList an ArrayList of Item objects
         * @return an ArrayList of U2 rockets that together carry all items from the itemList
         */
        ArrayList<U2> monofleet= new ArrayList<U2>();
        while (itemList.size()>0){
            U2 u2Rocket= new U2();
            for (int i=itemList.size()-1;i>=0;i--){
                if (u2Rocket.canCarry(itemList.get(i))){
                    u2Rocket.carry(itemList.get(i));
                    itemList.remove(i);
                }
            }
            monofleet.add(u2Rocket);
        }
        return monofleet;
    }
    public static <T extends Rocket>  int runSimulation(ArrayList<T> fleet){
        /**
         * runs the simulation
         * @param fleet an ArrayList of loaded rockets to be sent to Mars
         * @return  the total budget required to send all rockets (including the crashed ones).
         */
        int budgetRequired=0;
        for (Rocket rocket:fleet
             ) {
            while(!rocket.launch()||!rocket.land()){
                budgetRequired+=rocket.cost;

            }
            budgetRequired+=rocket.cost;
        }
        return budgetRequired;
    }

}
