package com.rbc.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 * Created by Gaurav on 10/10/2016.
 */
public interface FruitPriceService {
    /**
     * For the Set of fruits, this method returns the Price
     * @param fruits
     * @return
     */
    Map<String, BigDecimal> getPricesForFruit(Set<String> fruits);
}
