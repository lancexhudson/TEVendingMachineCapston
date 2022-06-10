package com.techelevator.dispensable;
import java.math.BigDecimal;

public class Gum implements Dispensable {
    public final String GUM_MESSAGE = "Chew Chew, Yum!";


    private String name;
    private BigDecimal price;
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

        return getName() + "|" + getPrice() + "|" + GUM_MESSAGE;

    }

//    public int getQuantity() {
//        return 0;//quantity;
//    }

    @Override
    public String getType() {
        return type;
    }


}
