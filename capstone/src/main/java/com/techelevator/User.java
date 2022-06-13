package com.techelevator;

import java.math.BigDecimal;
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
                        if(userDeposit.remainder(new BigDecimal(".05")).compareTo(BigDecimal.ZERO) != 0)
                        {
                            System.out.println("No pennies allowed.");
                        } else {
                            transaction.feedMoney(userDeposit);
                            logger.writeLog(userDeposit.setScale(2), transaction.getBalance(), "FEED MONEY"); //.setScale allows 2 decimal places in printout
                        }
                    } else if (purchaseInput.equals("2")) {

                        inventory.printMap(inventory.getItemInventory());
                        System.out.println("Please make your selection: ");
                        String itemChoice = userInput.nextLine();
                        if (inventory.getItemInventory().containsKey(itemChoice) && inventory.currentStock(itemChoice) != 0) {
                            if (transaction.getBalance().compareTo(inventory.getItemInventory().get(itemChoice).getPrice()) == 0 || transaction.getBalance().compareTo(inventory.getItemInventory().get(itemChoice).getPrice()) == 1) {
                                System.out.println(transaction.dispenseItem(itemChoice, inventory.getItemInventory().get(itemChoice)));
                                logger.writeLog(inventory.itemInventory.get(itemChoice).getPrice(), transaction.getBalance(), inventory.itemInventory.get(itemChoice).getName() + " " + itemChoice);
                                inventory.decrementStock(itemChoice);
                            } else {
                                System.out.println("Insufficient Funds.");
                            }
                        }  else if (!inventory.getItemInventory().containsKey(itemChoice)) {
                            System.out.println("Please select a valid item choice.");
                        } else if (inventory.currentStock(itemChoice) == 0) {
                            System.out.println("That item is out of stock");
                        }

                    } else if (purchaseInput.equals("3")) {
                        logger.writeLog(transaction.getBalance(), new BigDecimal("0.00"), "GIVE CHANGE");
                        System.out.println(transaction.getQuarters() + " Quarter(s) " + transaction.getDimes() + " Dime(s) " + transaction.getNickels() + " Nickel(s) ");

                    }

                }
                while (!purchaseInput.equals("3"));

            }
        } while (!input.equals("3"));

    }
}