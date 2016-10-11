package com.rbc.service;

import com.rbc.FruitBasketCalculatorImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Gaurav on 11/10/2016.
 */
public class FruitPriceServiceHandlerTest {

    FruitPriceServiceHandler fruitPriceService = null;

    @Before
    public void init() {
        Map<String, BigDecimal> map = new HashMap();
        map.put("Banana", new BigDecimal(1.2));
        map.put("Orange", new BigDecimal(2.3));
        map.put("Apple", new BigDecimal(1.4));
        map.put("Lemon", new BigDecimal(0.8));
        map.put("Peach", new BigDecimal(3.2));
        fruitPriceService = new FruitPriceServiceHandler();
        fruitPriceService.setInitialPrices(map);
    }

    @Test
    public void testGetPricesMissingFruit(){
        Set<String> set = new HashSet<>();
        set.add("Banana");
        set.add("Orange");
        set.add("Apple");
        set.add("Grape");
        Map<String, BigDecimal> prices = fruitPriceService.getPricesForFruit(set);
        assertEquals(4, prices.size());
        assertEquals(1.2, prices.get("Banana").doubleValue(), 0.01);
        assertNull(prices.get("Grape"));
    }

    @Test
    public void testGetPricesForFruit(){
        Set<String> set = new HashSet<>();
        set.add("Banana");
        set.add("Orange");
        set.add("Apple");
        Map<String, BigDecimal> prices = fruitPriceService.getPricesForFruit(set);
        assertEquals(3, prices.size());
        assertEquals(1.2, prices.get("Banana").doubleValue(), 0.01);
    }
}