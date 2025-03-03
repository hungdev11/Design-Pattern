package creational.abstractfactory;

public class SteelFurnitureFactory extends FurnitureAbstractFactory{
    @Override
    public Chair getChair() {
        return new SteelChair();
    }

    @Override
    public Table getTable() {
        return new SteelTable();
    }
}
