package creational.abstractfactory;

public class SteelChair implements Chair{
    @Override
    public void create() {
        System.out.println("Steel chair");
    }
}
