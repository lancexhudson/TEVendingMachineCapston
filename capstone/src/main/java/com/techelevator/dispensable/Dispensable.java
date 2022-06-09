package com.techelevator.dispensable;

import java.math.BigDecimal;

public interface Dispensable {

    public String getName();
    public void setName(String name);

    public BigDecimal getPrice();
    public void setPrice(BigDecimal price);

    public int dispense();







}
