package creational.abstractfactory;

/**
 * Abstract Factory is a creational pattern that provide an interface for
 * create families of related or dependent objects without specifying their
 * concrete classes
 */
public class AbstractFactory {
    public static void main(String[] args) {
        FurnitureAbstractFactory furnitureFactory = FurnitureFactory.getFactory(MaterialType.WOODEN);
        furnitureFactory.createChair().create();
        furnitureFactory.createTable().create();
    }
}
class FurnitureFactory {
    public static FurnitureAbstractFactory getFactory(MaterialType type) {
        switch (type) {
            case WOODEN:
                return new WoodenFactory();
            case PLASTIC:
                return new PlasticFactory();
            default:
                throw new RuntimeException("Undefined furniture type");
        }
    }
}
enum MaterialType {
    WOODEN, PLASTIC
}
interface Chair {void create();}
class WoodenChair implements Chair {
    @Override
    public void create() {
        System.out.println("Wooden chair created");
    }
}
class PlasticChair implements Chair {
    @Override
    public void create() {
        System.out.println("Plastic chair created");
    }
}
interface Table {void create();}
class WoodenTable implements Table {
    @Override
    public void create() {
        System.out.println("Wooden table created");
    }
}
class PlasticTable implements Table {
    @Override
    public void create() {
        System.out.println("Plastic table created");
    }
}
interface FurnitureAbstractFactory {
    Chair createChair();
    Table createTable();
}
class WoodenFactory implements FurnitureAbstractFactory{

    @Override
    public Chair createChair() {
        return new WoodenChair();
    }

    @Override
    public Table createTable() {
        return new WoodenTable();
    }
}
class PlasticFactory implements FurnitureAbstractFactory{

    @Override
    public Chair createChair() {
        return new PlasticChair();
    }

    @Override
    public Table createTable() {
        return new PlasticTable();
    }
}

