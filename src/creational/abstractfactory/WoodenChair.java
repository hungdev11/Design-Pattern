package creational.abstractfactory;

public class WoodenChair implements Chair{
    @Override
    public void create() {
        System.out.println("Wooden chair");
    }
}
