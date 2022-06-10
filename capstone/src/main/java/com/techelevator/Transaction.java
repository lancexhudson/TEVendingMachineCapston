package com.techelevator;
import com.techelevator.dispensable.Dispensable;

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

    public String dispenseItem(String itemLocation, Dispensable dispensable) {
//        inventory.initializeInventory();

        //happy path valid choice
//        if (inventory.getItemInventory().containsKey(itemLocation) && inventory.currentStock(itemLocation) != 0){
//            if (getBalance().compareTo(inventory.getItemInventory().get(itemLocation).getPrice()) == 0 || getBalance().compareTo(inventory.getItemInventory().get(itemLocation).getPrice()) == 1) {
        balance = balance.subtract(dispensable.getPrice());
        inventory.decrementStock(itemLocation);
        return (dispensable.dispense(itemLocation));
        //return "Insufficient Funds.";
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
