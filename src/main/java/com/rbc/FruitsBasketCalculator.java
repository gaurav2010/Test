package com.rbc;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Gaurav  on 10/10/2016.
 */
public interface FruitsBasketCalculator {

    /**
     * Calculate the price of the Basket for the list of fruits provided
     * @param fruits
     * @return
     */
    BigDecimal calculateBasketCost(List<String> fruits);
}
