package com.techelevator.dispensable;

import java.math.BigDecimal;

public interface Dispensable {

    public String getName();

    public void setName(String name);

    public BigDecimal getPrice();

    public void setPrice(BigDecimal price);

    public String getType();

    public String dispense(String itemLocation);

//    public int getQuantity();
}
