package com.techelevator;

import com.techelevator.dispensable.Chips;
import com.techelevator.dispensable.Dispensable;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TransactionTests {

    @Test
    public void get_quarters_test() {
        Transaction testTransaction = new Transaction();
        testTransaction.setBalance(new BigDecimal("4.35"));
        BigDecimal actual = testTransaction.getQuarters();
        Assert.assertEquals(new BigDecimal("17"), actual);
    }

    @Test
    public void get_dimes_test() {
        Transaction testTransaction = new Transaction();
        testTransaction.setBalance(new BigDecimal("4.35"));
        BigDecimal actual = testTransaction.getDimes();
        Assert.assertEquals(new BigDecimal("43"), actual);
    }

    @Test
    public void get_nickels_test() {
        Transaction testTransaction = new Transaction();
        testTransaction.setBalance(new BigDecimal("0.35"));
        BigDecimal actual = testTransaction.getNickels();
        Assert.assertEquals(new BigDecimal("7"), actual);
    }

    @Test
    public void feed_moneys_test() {
        Transaction testTransaction = new Transaction();
        testTransaction.setBalance(new BigDecimal("1.50"));
        BigDecimal expected = new BigDecimal("2.50");
        BigDecimal actual = testTransaction.feedMoney(new BigDecimal("1.00"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dispense_item_test() {
        Transaction testTransaction = new Transaction();
        Chips chip = new Chips();
        chip.setPrice(new BigDecimal("3.05"));
        chip.setName("Potato Crisps");
        String chipTest = "A1";
        testTransaction.setBalance(new BigDecimal("5.00"));
        String expected = "Potato Crisps|3.05|Crunch Crunch, Yum!";
        String actual = testTransaction.dispenseItem(chipTest, chip);
        Assert.assertEquals(expected, actual);

    }
}
