package creational.factorymethod;

public class BankFactory {
    private BankFactory(){}
    public static Bank getBank(int bankNumber) {
        return switch (bankNumber) {
            case 1 -> new Vietcombank();
            case 2 -> new Viettinbank();
            default -> throw new RuntimeException("Can not find bank correspond number " + bankNumber);
        };
    }
}
