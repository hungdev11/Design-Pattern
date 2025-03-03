package creational.factorymethod;

public class Client {
    public static void main(String[] args) {
        Bank bank = BankFactory.getBank(1);
        System.out.println(bank.getBankName());
        Bank bank2 = BankFactory.getBank(2);
        System.out.println(bank2.getBankName());
        Bank bank3 = BankFactory.getBank(3);
        System.out.println(bank3.getBankName());
    }
}
