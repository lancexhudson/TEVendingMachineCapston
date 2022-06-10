package com.techelevator;

import java.io.File;
import java.math.BigDecimal;

public class Transaction {

    BigDecimal balance = new BigDecimal("0.00");
    Inventory inventory = new Inventory();

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal feedMoney(BigDecimal deposit) {
        balance = balance.add(deposit);
        return balance;
    }

    public String dispenseItem(String itemLocation) {
        inventory.initializeInventory();

        //happy path valid choice
        if (inventory.getItemInventory().containsKey(itemLocation) && inventory.currentStock(itemLocation) != 0) {//inventory.getItemInventory().get(itemLocation).getQuantity() != 0) {
            if (getBalance().compareTo(inventory.getItemInventory().get(itemLocation).getPrice()) == 0 || getBalance().compareTo(inventory.getItemInventory().get(itemLocation).getPrice()) == 1) {
                balance = balance.subtract(inventory.getItemInventory().get(itemLocation).getPrice());
                inventory.decrementStock(itemLocation);
                return (inventory.getItemInventory().get(itemLocation).dispense(itemLocation));
            } else {
                return "Insufficient Funds.";
            }
        }
        //invalid choice
        else if (!inventory.getItemInventory().containsKey(itemLocation)) {
            return ("Please select a valid item choice.");
        }
        //out of stock
        else if (inventory.currentStock(itemLocation) == 0)//else if (inventory.getItemInventory().get(itemLocation).getQuantity() == 0) {
            return ("That item is out of stock");
        else {
            return null;
        }
    }


    public BigDecimal getQuarters() {
        BigDecimal numQuarters;

        numQuarters = getBalance().divideAndRemainder(new BigDecimal(".25"))[0];
        balance = getBalance().divideAndRemainder(new BigDecimal(".25"))[1];

        return numQuarters;

    }

    public BigDecimal getDimes() {
        BigDecimal numDimes;

        numDimes = getBalance().divideAndRemainder(new BigDecimal(".10"))[0];
        balance = getBalance().divideAndRemainder(new BigDecimal(".10"))[1];

        return numDimes;
    }

    public BigDecimal getNickels() {
        BigDecimal numNickels;

        numNickels = getBalance().divideAndRemainder(new BigDecimal(".05"))[0];
        balance = getBalance().divideAndRemainder(new BigDecimal(".05"))[1];

        return numNickels;
    }


}
