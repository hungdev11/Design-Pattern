package behavioral.command;
/**
 * Sometimes we need to send request to objects, but we don't know anything about activity of request or receiver
 * Command pattern encapsulate a request into an object, thereby letting you parameterize clients with different requests,
 * queue (undo, redo) or log requests, transaction.
 */
public class OpenAccountExample {
    public static void main(String[] args) {
        Account account = new Account("Hung");

        Command open = new OpenAccount(account);
        Command close = new CloseAccount(account);

        BankApp bankApp = new BankApp();
        bankApp.click(open);
        bankApp.click(close);
    }
}
class Account {
    private String name;
    public Account(String name) {
        this.name = name;
    }
    public void open() {
        System.out.println("Account [" + name + "] Opened\n");
    }
    public void close() {
        System.out.println("Account [" + name + "] Closed\n");
    }
}
interface Command {
    void execute();
    String getSimpleName();
}
class BankApp {
    public void click(Command command) {
        System.out.println("User click " + command.getSimpleName());
        command.execute();
    }
}
class OpenAccount implements Command {
    private Account account;
    public OpenAccount(Account account) {
        this.account = account;
    }
    @Override
    public void execute() {
        account.open();
    }
    @Override
    public String getSimpleName() {
        return "Open account";
    }
}
class CloseAccount implements Command {
    private Account account;
    public CloseAccount(Account account) {
        this.account = account;
    }
    @Override
    public void execute() {
        account.close();
    }

    @Override
    public String getSimpleName() {
        return "Close account";
    }
}
