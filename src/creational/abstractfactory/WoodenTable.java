package creational.abstractfactory;

public class WoodenTable implements Table{
    @Override
    public void create() {
        System.out.println("Wooden table");
    }
}
