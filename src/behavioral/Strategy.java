package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Strategy pattern define a family of algorithms, encapsulate each one and make them interchangeable
 * Strategy lets the algorithms vary independently form the clients that use it.
 * separate handling process form object and create a set of algorithms to handle that function
 */
public class Strategy {
    public static void main(String[] args) {
        Context1 context1 = new Context1();
        context1.setStrategy(new QuickSort());
        context1.sort();
        context1.setStrategy(new MergeSort());
        context1.sort();
    }
}
class Context1 {
    private SortStrategy strategy;
    private List<String> items = new ArrayList<>();
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    public void add(String name) {
        items.add(name);
    }
    public void sort(){
        strategy.sort(items);
    }
}
interface SortStrategy {
    <T> void sort (List<T> items);
}
class MergeSort implements SortStrategy {
    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Merge sort");
    }
}
class QuickSort implements SortStrategy {
    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Quick sort");
    }
}
class TimSort implements SortStrategy {
    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Tim sort");
    }
}
