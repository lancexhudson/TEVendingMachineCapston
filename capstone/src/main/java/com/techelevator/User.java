package com.techelevator;

import com.techelevator.dispensable.Dispensable;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class User {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        String input;
        Inventory inventory = new Inventory();
        Transaction transaction = new Transaction();
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
// we will need another loop if product is sold out or doesn't exist

                System.out.println("Current Money Provided: $" + transaction.getBalance());
                System.out.println("(1) Feed Money");
                System.out.println("(2) Select Product");
                System.out.println("(3) Finish Transaction");

                String purchaseInput = userInput.nextLine();

                if (purchaseInput.equals("1")) {
                    System.out.println("Enter the amount you would like to deposit: ");
                    BigDecimal userDeposit = new BigDecimal(userInput.nextLine());
                    transaction.feedMoney(userDeposit);

                } else if (purchaseInput.equals("2")) {
                    //display available products
                    //Show the list of products available and allow the customer to enter a code to select an item.
                    //If the product code doesn't exist, the vending machine informs the customer and returns them to the Purchase menu.
                    //If a product is currently sold out, the vending machine informs the customer and returns them to the Purchase menu.
                    //If a customer selects a valid product, it's dispensed to the customer.
                    //call dispenseItem method here
                    inventory.printMap(inventory.getItemInventory());
                    System.out.println("Please make your selection: ");
                    String itemChoice = userInput.nextLine();
                    System.out.println(transaction.dispenseItem(itemChoice));

                } else if (purchaseInput.equals("3")) {
                    //dispense change
                    //return to main menu
                }
            } else if (input.equals("3")) {

            }
        } while (!input.equals("3"));

    }


}
