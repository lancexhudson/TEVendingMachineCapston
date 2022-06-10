package com.techelevator;

import com.techelevator.dispensable.Dispensable;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class User {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        String input;
        String purchaseInput;
        Inventory inventory = new Inventory();
        Transaction transaction = new Transaction();
        Logger logger = new Logger();

        inventory.initializeInventory();

        do {
            System.out.println("");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");

            input = userInput.nextLine();

            if (input.equals("1")) {
                inventory.printMap(inventory.getItemInventory());

            } else if (input.equals("2")) {
                do {
                    System.out.println("Current Money Provided: $" + transaction.getBalance());
                    System.out.println("(1) Feed Money");
                    System.out.println("(2) Select Product");
                    System.out.println("(3) Finish Transaction");

                    purchaseInput = userInput.nextLine();

                    if (purchaseInput.equals("1")) {
                        System.out.println("Enter the amount you would like to deposit: ");
                        BigDecimal userDeposit = new BigDecimal(userInput.nextLine());
                        transaction.feedMoney(userDeposit);
                        logger.writeLog(userDeposit.setScale(2), transaction.getBalance(), "FEED MONEY"); //.setScale allows 2 decimal places in printout

                    } else if (purchaseInput.equals("2")) {

                        inventory.printMap(inventory.getItemInventory());
                        System.out.println("Please make your selection: ");
                        String itemChoice = userInput.nextLine();
                        System.out.println(transaction.dispenseItem(itemChoice));
                        if (inventory.itemInventory.containsKey(itemChoice)) {
                            logger.writeLog(inventory.itemInventory.get(itemChoice).getPrice(), transaction.getBalance(), inventory.itemInventory.get(itemChoice).getName() + " " + itemChoice);
                        }

                    } else if (purchaseInput.equals("3")) {
                        logger.writeLog(transaction.getBalance(), new BigDecimal("0.00"), "GIVE CHANGE");
                        System.out.println(transaction.getQuarters() + " Quarters " + transaction.getDimes() + " Dimes " + transaction.getNickels() + " Nickels ");

                    }

                } while (!purchaseInput.equals("3"));

            }
        } while (!input.equals("3"));

    }
}