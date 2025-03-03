package creational.abstractfactory;

public abstract class FurnitureAbstractFactory {
    public abstract Chair getChair();
    public abstract Table getTable();
    void getFurnitureSet() {
        System.out.println("Processing...");
        getChair().create();
        getTable().create();
    }
}
