package com.techelevator;

import com.techelevator.dispensable.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {
    Map<String, Dispensable> itemInventory = new HashMap<>();

    File vendingMachine = new File("vendingmachine.csv");

    private String[] itemSignature;

    public void initializeInventory(){

        try (Scanner scanner = new Scanner(vendingMachine)){
            while(scanner.hasNextLine()){
                itemSignature = scanner.nextLine().split("\\|");
                if(itemSignature[3].toLowerCase().equals("drink"))
                {
                    itemInventory.put(itemSignature[0], new Beverage());
                    itemInventory.get(itemSignature[0]).setName(itemSignature[1]);
                    itemInventory.get(itemSignature[0]).setPrice(new BigDecimal(itemSignature[2]));
                } else if (itemSignature[3].toLowerCase().equals("gum")){
                    itemInventory.put(itemSignature[0], new Gum());
                    itemInventory.get(itemSignature[0]).setName(itemSignature[1]);
                    itemInventory.get(itemSignature[0]).setPrice(new BigDecimal(itemSignature[2]));
                } else if(itemSignature[3].toLowerCase().equals("chip")){
                    itemInventory.put(itemSignature[0], new Chips());
                    itemInventory.get(itemSignature[0]).setName(itemSignature[1]);
                    itemInventory.get(itemSignature[0]).setPrice(new BigDecimal(itemSignature[2]));
                } else if(itemSignature[3].toLowerCase().equals("candy")){
                    itemInventory.put(itemSignature[0], new Candy());
                    itemInventory.get(itemSignature[0]).setName(itemSignature[1]);
                    itemInventory.get(itemSignature[0]).setPrice(new BigDecimal(itemSignature[2]));
                }
            }
        } catch (FileNotFoundException fileNotFoundException){
            System.out.println("File not found.");
        }
    }
    public void printMap(Map<String, Dispensable> itemInventory){

        Map<String, Dispensable> sortedInventory = new TreeMap<>(itemInventory);
        for(Map.Entry<String, Dispensable> entry : sortedInventory.entrySet()){
            System.out.println(entry.getKey() + "|" + entry.getValue().getName() + "|" + entry.getValue().getPrice() + "|" + entry.getValue().getType());
        }

    }

    public Map<String, Dispensable> getItemInventory(){
        return itemInventory;
    }

}
