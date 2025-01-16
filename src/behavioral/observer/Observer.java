package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *  Define a one to many dependency between objects so that
 *  when one object changes state, all its dependents are notified and updated automatically
 *
 */
class ObserverPatternExample {
    public static void main(String[] args) {
        AccountService account1 = createAccount("contact@hung.com", "127.0.0.1");
        account1.login();
        account1.changeStatus(LoginStatus.EXPIRED);

        System.out.println("---");
        AccountService account2 = createAccount("contact@hung.com", "116.108.77.231");
        account2.login();
    }

    private static AccountService createAccount(String email, String ip) {
        AccountService account = new AccountService(email, ip);
        account.attach(new Logger());
        account.attach(new Mailer());
        account.attach(new Protector());
        return account;
    }
}
public interface Observer {
    void update(User user);
}
class Logger implements Observer {
    @Override
    public void update(User user) {
        System.out.println("Logger: " + user);
    }
}
class Protector implements Observer {
    @Override
    public void update(User user) {
        if (user.getStatus() == LoginStatus.INVALID) {
            System.out.println("Protector: User " + user.getEmail() + " is invalid. "
                    + "IP " + user.getIp() + " is blocked");
        }
    }
}
class Mailer implements Observer {
    @Override
    public void update(User user) {
        if (user.getStatus() == LoginStatus.EXPIRED) {
            System.out.println("Mailer: User " + user.getEmail() + " is expired. An email was sent!");
        }
    }
}
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyAllObserver();
}
enum LoginStatus {
    SUCCESS, FAILURE, INVALID, EXPIRED
}
class User {
    private String email;
    private String ip;
    private LoginStatus status;
    public User (){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LoginStatus getStatus() {
        return status;
    }

    public void setStatus(LoginStatus status) {
        this.status = status;
    }
}

class AccountService implements Subject{
    private User user;
    private List<Observer> observers = new ArrayList<>();
    public AccountService(String email, String ip) {
        user = new User();
        user.setEmail(email);
        user.setIp(ip);
    }
    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObserver() {
        observers.forEach(o -> o.update(user));
    }

    public void changeStatus(LoginStatus status) {
        user.setStatus(status);
        System.out.println("Status is changed");
        this.notifyAllObserver();
    }

    public void login() {
        if (!this.isValidIP()) {
            user.setStatus(LoginStatus.INVALID);
        } else if (this.isValidEmail()) {
            user.setStatus(LoginStatus.SUCCESS);
        } else {
            user.setStatus(LoginStatus.FAILURE);
        }
        System.out.println("Login is handled");
        this.notifyAllObserver();
    }

    private boolean isValidIP() {
        return "127.0.0.1".equals(user.getIp());
    }

    private boolean isValidEmail() {
        return "contact@hung.com".equalsIgnoreCase(user.getEmail());
    }
}
