package com.techelevator.dispensable;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Copy {
//
//    public void initializeInventory() {
//        String[] itemSignature;
//        try (Scanner scanner = new Scanner(vendingMachine)) {
//            while (scanner.hasNextLine()) {
//                itemSignature = scanner.nextLine().split("\\|");
//                if (itemSignature[3].toLowerCase().equals("drink")) {
//                    itemInventory.put(itemSignature[0], new Beverage());
//                    itemInventory.get(itemSignature[0]).setName(itemSignature[1]);
//                    itemInventory.get(itemSignature[0]).setPrice(new BigDecimal(itemSignature[2]));
//                } else if (itemSignature[3].toLowerCase().equals("gum")) {
//                    itemInventory.put(itemSignature[0], new Gum());
//                    itemInventory.get(itemSignature[0]).setName(itemSignature[1]);
//                    itemInventory.get(itemSignature[0]).setPrice(new BigDecimal(itemSignature[2]));
//                } else if (itemSignature[3].toLowerCase().equals("chip")) {
//                    itemInventory.put(itemSignature[0], new Chips());
//                    itemInventory.get(itemSignature[0]).setName(itemSignature[1]);
//                    itemInventory.get(itemSignature[0]).setPrice(new BigDecimal(itemSignature[2]));
//                } else if (itemSignature[3].toLowerCase().equals("candy")) {
//                    itemInventory.put(itemSignature[0], new Candy());
//                    itemInventory.get(itemSignature[0]).setName(itemSignature[1]);
//                    itemInventory.get(itemSignature[0]).setPrice(new BigDecimal(itemSignature[2]));
//                }
//            }
//        } catch (FileNotFoundException fileNotFoundException) {
//            System.out.println("File not found.");
//        }
//    }


//    public String dispenseItem(String itemLocation) {
//        inventory.initializeInventory();
//
//        //happy path valid choice
//        if (inventory.getItemInventory().containsKey(itemLocation) && inventory.currentStock(itemLocation) != 0){
//            if (getBalance().compareTo(inventory.getItemInventory().get(itemLocation).getPrice()) == 0 || getBalance().compareTo(inventory.getItemInventory().get(itemLocation).getPrice()) == 1) {
//                balance = balance.subtract(inventory.getItemInventory().get(itemLocation).getPrice());
//                inventory.decrementStock(itemLocation);
//                return (inventory.getItemInventory().get(itemLocation).dispense(itemLocation));
//            } else {
//                return "Insufficient Funds.";
//            }
//        }
//        //invalid choice
//        else if (!inventory.getItemInventory().containsKey(itemLocation)) {
//            return ("Please select a valid item choice.");
//        }
//        //out of stock
//        else if (inventory.currentStock(itemLocation) == 0)//else if (inventory.getItemInventory().get(itemLocation).getQuantity() == 0) {
//            return ("That item is out of stock");
//        else {
//            return null;
//        }
//    }






}
