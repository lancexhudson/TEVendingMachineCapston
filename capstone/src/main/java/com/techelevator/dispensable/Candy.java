package com.techelevator.dispensable;
import java.math.BigDecimal;

public class Candy implements Dispensable {
    public final String CANDY_MESSAGE = "Munch Munch, Yum!";

    private String name;
    private BigDecimal price;
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

        return getName() + "|" + getPrice() + "|" + CANDY_MESSAGE;

    }

//    public int getQuantity() {
//        return 0;//quantity;
//    }

    @Override
    public String getType() {
        return type;
    }
}
