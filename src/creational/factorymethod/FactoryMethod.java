package creational.factorymethod;

import org.w3c.dom.ls.LSOutput;

/**
 * Factory method ís a creational pattern that define an interface for creating an object,
 * but let subclasses decide which class to instantiate
 * Factory method lets a class defer instantiation to subclasses
 * manage and return object follow requirements
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Bank bank = BankFactory.getBank(BankType.VIETCOMBANK);
        System.out.println(bank.getBankName());
    }
}
class BankFactory {
    public static Bank getBank(BankType bankType) {
        switch (bankType) {
            case TPBANK:
                return new TPBank();
            case VIETCOMBANK:
                return new VietcomBank();
            default:
                throw new IllegalArgumentException("Undefined type");
        }
    }
}
enum BankType {
    TPBANK, VIETCOMBANK
}
// can be interface, abstract class, concrete class
interface Bank {
    String getBankName();
}
class TPBank implements Bank {
    @Override
    public String getBankName() {
        return "TPBank";
    }
}
class VietcomBank implements Bank {
    @Override
    public String getBankName() {
        return "VietcomBank";
    }
}
