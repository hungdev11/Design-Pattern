package creational.abstractfactory;

public class WoodenFurnitureFactory extends FurnitureAbstractFactory{
    @Override
    public Chair getChair() {
        return new WoodenChair();
    }

    @Override
    public Table getTable() {
        return new WoodenTable();
    }
}
