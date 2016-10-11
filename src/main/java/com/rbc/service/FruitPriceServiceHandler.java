package com.rbc.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Gaurav  on 10/10/2016.
 */
public class FruitPriceServiceHandler implements FruitPriceService {

    // To support concurrency - ConcurretHashMap is used
    // Please note that it is declared final
    private final Map<String, BigDecimal> prices = new ConcurrentHashMap<>();

    /**
     * This is a test program as so we have only loaded the static price at beginning
     * In real-world - we will also implement real-time pricing updates, Other methods that
     * should be added to this Handler are
     *       1. Update Price
     *       2. Update fruits List with new Prices
     */
    public void setInitialPrices(Map<String, BigDecimal> openingPrice){
        prices.putAll(openingPrice);
    }


    @Override
    public Map<String, BigDecimal> getPricesForFruit(Set<String> fruits) {

        final Map<String, BigDecimal> selectedFruitPrices = new HashMap<>();
        fruits.stream().forEach(
                s -> selectedFruitPrices.put(s, prices.get(s))
        );
        return selectedFruitPrices;
    }
}
