package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public static ArrayList<Item> loadItems(File textfile) throws Exception{
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
}
