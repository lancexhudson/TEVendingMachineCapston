package com.techelevator.dispensable;

import com.techelevator.Inventory;

import java.math.BigDecimal;

public class Gum implements Dispensable {
    Inventory inventory = new Inventory();
    public final String GUM_MESSAGE = "Chew Chew, Yum!";


    private String name;
    private BigDecimal price;
    //private int quantity = 5;
    private String type = "Gum";

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
        //quantity--;
        return inventory.getItemInventory().get(itemLocation).getName() + "|" + inventory.getItemInventory().get(itemLocation).getPrice() + "|" + GUM_MESSAGE;

    }

//    Added this method to each item class
//    public void decrementStock(String itemLocation){
//        inventory.getItemQuantity().put(itemLocation, inventory.getItemQuantity().get(itemLocation) - 1);
//    }

    public int getQuantity() {
        return 0;//quantity;
    }

    @Override
    public String getType() {
        return type;
    }


}
