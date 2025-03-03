package creational.abstractfactory;

public class FurnitureFactory {
    private FurnitureFactory(){}
    public static FurnitureAbstractFactory getFurnitureFactory(MaterialType type) {
        return switch (type) {
            case WOOD -> new WoodenFurnitureFactory();
            case STEEL -> new SteelFurnitureFactory();
        };
    }
}
