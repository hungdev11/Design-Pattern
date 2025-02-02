package creational.singleton.practices;

import java.util.HashMap;
import java.util.Map;

/**
 * You are working on a e-commerce application that manages the stock of products available in the warehouse.
 * The stock is maintained in a singleton class StockManager. The class has a private constructor so that
 * no other class can create an instance of it. The class has a private static instance of itself and a public
 * static method getInstance to return the instance.
 * The stock manager class should be thread-safe, meaning that multiple threads can access the class simultaneously
 * without any issues. How would you implement the StockManager class?
 */
public class Question1 {

}
class StockManager {
    private StockManager(){}
    private static volatile StockManager INSTANCE;
    public static StockManager getInstance() {
        if (INSTANCE == null) {
            synchronized (StockManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new StockManager();
                }
            }
        }
        return INSTANCE;
    }
}
class StockManager2 {
    private final Map<String, Double> stocks;
    private StockManager2(){
        stocks = new HashMap<>();
    }
    private static class Holder {
        private static final StockManager2 INSTANCE = new StockManager2();
    }
    public static StockManager2 getInstance() {
        return Holder.INSTANCE;
    }
    public Double getStockPrice(String code) {
        return stocks.getOrDefault(code, 0.0);
    }
    public void updateStock(String code, Double price) {
        stocks.put(code, price);
    }
}
