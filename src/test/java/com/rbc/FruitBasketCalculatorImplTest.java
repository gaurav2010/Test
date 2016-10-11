package com.rbc;

import com.rbc.service.FruitPriceServiceHandler;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gaurav on 10/10/2016.
 */
public class FruitBasketCalculatorImplTest {

    FruitBasketCalculatorImpl fruitBasketCalculatorImpl = null;

    @Before
    public void init(){
        Map<String, BigDecimal> map = new HashMap();
        map.put("Banana", new BigDecimal(1.2));
        map.put("Orange", new BigDecimal(2.3));
        map.put("Apple", new BigDecimal(1.4));
        map.put("Lemon", new BigDecimal(0.8));
        map.put("Peach", new BigDecimal(3.2));

        FruitPriceServiceHandler fruitPriceService = new FruitPriceServiceHandler();
        fruitPriceService.setInitialPrices(map);
        fruitBasketCalculatorImpl = new FruitBasketCalculatorImpl(fruitPriceService);
    }

    @Test
    public void testSimpleBasketPrice(){
        List<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Orange");
        list.add("Banana");
        list.add("Banana");
        list.add("Banana");
        list.add("Peach");
        list.add("Apple");
        BigDecimal basketPrice = fruitBasketCalculatorImpl.calculateBasketCost(list);
        assertEquals(11.7, basketPrice.doubleValue(), 0.01);
    }

    @Test
    public void testRaiseExceptionForNewFruitBasketPrice(){
        List<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Orange");
        list.add("Banana");
        list.add("Banana");
        list.add("Banana");
        list.add("Peach");
        list.add("Apple");
        list.add("Grape");
        try {
            BigDecimal basketPrice = fruitBasketCalculatorImpl.calculateBasketCost(list);
        }catch(UnsupportedOperationException uoe){
            assertEquals("Price for don't exist for fruit: Grape" , uoe.getMessage());
        }

    }

    @Test
    public void testEmptyFruitBasketPrice(){
        List<String> list = new ArrayList<>();
        BigDecimal basketPrice = fruitBasketCalculatorImpl.calculateBasketCost(list);
        assertEquals(0L, basketPrice.doubleValue(), 0.01);

    }
}