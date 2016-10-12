The reason for this project is to publish the Test-Solution to RBC

Task -  Please write a program that takes a basket of items and outputs its total cost.
        The basket can contain one or more of the following items: Bananas, Oranges, Apples, Lemons, Peaches


Solution Overview -

        -   Created Interface FruitBasketCalculator that takes a List of fruits as in a Till machine and provide the total cost
        
        -   FruitBasketCalculatorImpl implements FruitBasketCalculator and gets real-time price of fruits
            from FruitPriceService that exposes method getPricesForFruit. 
            Please note that this uses BigDecimal to eliminate "Floating Point Error"
            
        -   The FruitPriceServiceImpl simulates the real-time price. 
            This program is capable to supporting concurrent updates and fetch to the prices


Test (UNIT TEST) -

        -   Junit-4 is used to unit test the solution

Other Obvious Improvements

        -   FruitPriceServiceImpl should be injected from a frame-work like Spring in real-world
        
        -   The FruitPriceServiceImpl should expose more Admin methods to update real-time pricing
        
        -   In current solution, If a fruit price is not available - currently it throws RunTimeExcetion "UnsupportedOperationException"
        
                We should look into the use-case and handle this scenario gracefully
                
