package creational.builder;

/**
 * Builder is a creational pattern that separate the construction of a complex
 * object from its representation so that the same construction process can create
 * different representations.
 *
 * Why:
 * - a class can has multiple constructor correspond with fields -> if class has too many fields?
 * - 1 fully params constructor, no need set it to null -> hard to read, maintain and no one can remember the order of params
 * - builder pattern help your code more readable by build object step by step and choose what field need to exist
 */
public class Builder {
    public static void main(String[] args) {
        Order order = new FastFoodOrderBuilder()
                .orderBread(BreadType.BEEF)
                .orderVegetable(VegetableType.SALAD)
                .orderSauce(SauceType.MUSTARD)
                .orderType(OrderType.TAKE_AWAY)
                .build();
        System.out.println(order);
    }
}
class Order {
    private OrderType orderType;
    private BreadType breadType;
    private VegetableType vegetableType;
    private SauceType sauceType;
    public Order (OrderType orderType, BreadType breadType, SauceType sauceType, VegetableType vegetableType) {
        this.breadType = breadType;
        this.sauceType = sauceType;
        this.vegetableType = vegetableType;
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderType=" + orderType +
                ", breadType=" + breadType +
                ", vegetableType=" + vegetableType +
                ", sauceType=" + sauceType +
                '}';
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public VegetableType getVegetableType() {
        return vegetableType;
    }

    public SauceType getSauceType() {
        return sauceType;
    }
}
interface OrderBuilder {
    OrderBuilder orderType(OrderType orderType);
    OrderBuilder orderVegetable(VegetableType vegetableType);
    OrderBuilder orderSauce(SauceType sauceType);
    OrderBuilder orderBread(BreadType breadType);
    Order build();
}
class FastFoodOrderBuilder implements OrderBuilder{
    private OrderType orderType;
    private BreadType breadType;
    private VegetableType vegetableType;
    private SauceType sauceType;

    @Override
    public OrderBuilder orderType(OrderType orderType) {
        this.orderType = orderType;
        return this;
    }

    @Override
    public OrderBuilder orderVegetable(VegetableType vegetableType) {
        this.vegetableType = vegetableType;
        return this;
    }

    @Override
    public OrderBuilder orderSauce(SauceType sauceType) {
        this.sauceType = sauceType;
        return this;
    }

    @Override
    public OrderBuilder orderBread(BreadType breadType) {
        this.breadType = breadType;
        return this;
    }

    @Override
    public Order build() {
        return new Order(orderType, breadType, sauceType, vegetableType);
    }
}

