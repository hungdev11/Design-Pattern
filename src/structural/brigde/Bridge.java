package structural.brigde;

/**
 * Bridge design pattern decouple an abstraction from its implementation
 * so that the two can vary (change) independently
 */
public class Bridge {
    public static void main(String[] args) {
        Bank vietcomBank = new VietcomBank(new SavingAccount());
        Bank BIDV = new BIDV(new InvestAccount());
        vietcomBank.openAccount();
        BIDV.openAccount();
    }
}
abstract class Bank {
    Account account;
    Bank (Account account) {
        this.account = account;
    }
    public abstract void openAccount();
}
interface Account {
    String openAccount();
}
class BIDV extends Bank{
    BIDV(Account account) {
        super(account);
    }
    @Override
    public void openAccount() {
        System.out.println("BIDV: open new " + account.openAccount());
    }
}
class VietcomBank extends Bank{
    VietcomBank(Account account) {
        super(account);
    }
    @Override
    public void openAccount() {
        System.out.println("VietcomBank: open new " + account.openAccount());
    }
}
class SavingAccount implements Account {
    @Override
    public String openAccount() {
        return "saving account";
    }
}
class InvestAccount implements Account {
    @Override
    public String openAccount() {
        return "invest account";
    }
}
