package com.rbc;

import com.rbc.service.FruitPriceService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Gaurav  on 10/10/2016.
 */
public class FruitBasketCalculatorImpl implements FruitsBasketCalculator{

    /**
     * For concurrency the var is declared final
     */
    private final FruitPriceService fruitPricesService;

    public FruitBasketCalculatorImpl(FruitPriceService fruitPricesService){
        this.fruitPricesService = fruitPricesService;
    }

    @Override
    public BigDecimal calculateBasketCost(List<String> fruits) {

        if(fruits == null || fruits.size() == 0)
            return new BigDecimal(0L);

        final Map<String, Long> fruitMappedBasket = fruits.stream().collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));
        Map<String, BigDecimal> fruitPrices = fruitPricesService.getPricesForFruit(fruitMappedBasket.keySet());

        return fruitMappedBasket.entrySet().stream().map(
                entry -> {
                    BigDecimal itemPrice = fruitPrices.get(entry.getKey());
                    if(itemPrice == null)
                        throw new UnsupportedOperationException("Price for don't exist for fruit: " + entry.getKey());

                    return fruitPrices.get(entry.getKey()).multiply(new BigDecimal(entry.getValue()));
                }
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
