package com.techelevator;

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
        if (inventory.getItemInventory().containsKey(itemLocation) && inventory.getItemInventory().get(itemLocation).getQuantity() != 0) {
            balance = balance.subtract(inventory.getItemInventory().get(itemLocation).getPrice());

            return (inventory.getItemInventory().get(itemLocation).dispense(itemLocation));
        } else if (!inventory.getItemInventory().containsKey(itemLocation)) {
            return ("Please select a valid item choice.");
        } else if (inventory.getItemInventory().get(itemLocation).getQuantity() == 0) {
            return ("That item is out of stock");
        } else {
            return null;
        }
    }

    public BigDecimal dispenseChange() {
        return BigDecimal.ZERO;
    }


}
