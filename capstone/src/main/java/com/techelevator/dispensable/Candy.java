package com.techelevator.dispensable;

import com.techelevator.Inventory;

import java.math.BigDecimal;

public class Candy implements Dispensable {
    Inventory inventory = new Inventory();
    public final String CANDY_MESSAGE = "Munch Munch, Yum!";


    private String name;
    private BigDecimal price;
    private int quantity = 5;
    private String type = "Candy";


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String dispense(String itemLocation) {
        inventory.initializeInventory();
        quantity--;
        return inventory.getItemInventory().get(itemLocation).getName() + "|" + inventory.getItemInventory().get(itemLocation).getPrice() + "|" + CANDY_MESSAGE;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String getType() {
        return type;
    }
}
