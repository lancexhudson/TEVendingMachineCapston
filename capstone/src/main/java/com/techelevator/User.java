package com.techelevator;

import com.techelevator.dispensable.Dispensable;

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
                        logger.writeLog(userDeposit, transaction.getBalance());

                    } else if (purchaseInput.equals("2")) {

                        inventory.printMap(inventory.getItemInventory());
                        System.out.println("Please make your selection: ");
                        String itemChoice = userInput.nextLine();
                        System.out.println(transaction.dispenseItem(itemChoice));
                        logger.writeLog(inventory.itemInventory.get(itemChoice).getPrice(), transaction.getBalance());

                    } else if (purchaseInput.equals("3")) {
                        //dispense change
                        //return to main menu
                        logger.writeLog(transaction.getBalance(), BigDecimal.ZERO);
                        System.out.println(transaction.dispenseChange());

                    }

                } while (!purchaseInput.equals("3"));

            }
        } while (!input.equals("3"));

    }
}