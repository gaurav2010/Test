The reason for this project is to publish the Test-Solution to RBC

Task -  Please write a program that takes a basket of items and outputs its total cost.
        The basket can contain one or more of the following items: Bananas, Oranges, Apples, Lemons, Peaches


Solution Overview -

        -   Created Interface FruitBasketCalculator that takes a List of fruits as in a Till machine
        
        -   FruitBasketCalculatorImpl implements FruitBasketCalculator and gets real-time price of fruits
            from FruitPriceService that exposes method getPricesForFruit
            
        -   The FruitPriceServiceImpl simulates the real-time price (can support multi-threading)


Test (UNIT TEST) -

        -   Junit-4 is used to unit test the solution
        
        -   The unit test tests only the methods that are expected to be retained in real case
        
        -   Dummy methids are ignored

Other Obvious Improvements

        -   FruitPriceServiceImpl should be injected fromm a frame-work
        
        -   The FruitPriceServiceImpl should expose more Admin methods to update real-time pricing
        
        -   If a fruit price is not available - it throws RunTimeExcetion "UnsupportedOperationException"
        
                We should look into the use-case and handle this scenario gracefully
                
