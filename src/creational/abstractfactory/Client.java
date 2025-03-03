package creational.abstractfactory;

public class Client {
    public static void main(String[] args) {
        FurnitureAbstractFactory factory = FurnitureFactory.getFurnitureFactory(MaterialType.WOOD);
        factory.getFurnitureSet();
        FurnitureAbstractFactory factory2 = FurnitureFactory.getFurnitureFactory(MaterialType.STEEL);
        factory2.getFurnitureSet();
    }
}
