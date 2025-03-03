package creational.abstractfactory;

public class SteelTable implements Table{
    @Override
    public void create() {
        System.out.println("Steel table");
    }
}
