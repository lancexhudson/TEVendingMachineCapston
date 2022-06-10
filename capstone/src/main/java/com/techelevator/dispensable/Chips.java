package com.techelevator.dispensable;
import java.math.BigDecimal;

public class Chips implements Dispensable {
    public final String CHIP_MESSAGE = "Crunch Crunch, Yum!";

    private String name;
    private BigDecimal price;
    private String type = "Chip";

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

        return getName() + "|" + getPrice() + "|" + CHIP_MESSAGE;
    }


    @Override
    public String getType() {
        return type;
    }

}
