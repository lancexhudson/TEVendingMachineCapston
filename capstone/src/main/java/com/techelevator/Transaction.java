package com.techelevator;
import com.techelevator.dispensable.Dispensable;

import java.math.BigDecimal;
public class Transaction {

    BigDecimal balance = new BigDecimal("0.00");

    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal newBalance) {
        balance = newBalance;  //for testing
    }

    public BigDecimal feedMoney(BigDecimal deposit) {
        balance = balance.add(deposit);
        return balance;
    }

    public String dispenseItem(String itemLocation, Dispensable dispensable) {

        balance = balance.subtract(dispensable.getPrice());
        return (dispensable.dispense(itemLocation));

    }

    public BigDecimal getQuarters() {
        BigDecimal numQuarters;
        BigDecimal quarterValue = new BigDecimal("0.25");

        numQuarters = getBalance().divideAndRemainder(quarterValue)[0];
        balance = getBalance().divideAndRemainder(quarterValue)[1];

        return numQuarters;

    }

    public BigDecimal getDimes() {
        BigDecimal numDimes;
        BigDecimal dimeValue = new BigDecimal("0.10");

        numDimes = getBalance().divideAndRemainder(dimeValue)[0];
        balance = getBalance().divideAndRemainder(dimeValue)[1];

        return numDimes;
    }

    public BigDecimal getNickels() {
        BigDecimal numNickels;
        BigDecimal nickelValue = new BigDecimal("0.05");

        numNickels = getBalance().divideAndRemainder(nickelValue)[0];
        balance = getBalance().divideAndRemainder(nickelValue)[1];

        return numNickels;
    }


}
