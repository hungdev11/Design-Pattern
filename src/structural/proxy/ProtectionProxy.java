package structural.proxy;

public class ProtectionProxy {
    public static void main(String[] args) {
        UserService admin = new UserServiceProxy("hung", "admin");
        admin.load();
        admin.insert();

        UserService customer = new UserServiceProxy("customer", "guest");
        customer.load();
        customer.insert();
    }
}
interface UserService {
    void load();
    void insert();
}
class UserServiceImp implements UserService {
    private String name;
    public UserServiceImp(String name) {
        this.name = name;
    }
    @Override
    public void load() {
        System.out.println(name + " loaded");
    }

    @Override
    public void insert() {
        System.out.println(name + " inserted");
    }
}
class UserServiceProxy implements UserService {
    private UserService userService;
    private String role;

    public UserServiceProxy(String name, String role) {
        this.role = role;
        userService = new UserServiceImp(name);
    }
    @Override
    public void load() {
        userService.load();
    }

    @Override
    public void insert() {
        if (isAdmin(role)) {
            userService.insert();
        } else {
            throw new IllegalAccessError("Access denied");
        }
    }
    private boolean isAdmin(String role) {
        return role.equals("ADMIN".toLowerCase());
    }
}