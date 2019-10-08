package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public static ArrayList loadItems(File textfile) throws Exception{
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
}
