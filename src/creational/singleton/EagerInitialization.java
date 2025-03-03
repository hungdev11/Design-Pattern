package creational.singleton;

// create an instance when class be called, waste memory if not use immediately, can break by reflection
public class EagerInitialization {
    private static final EagerInitialization INSTANCE = new EagerInitialization();
    private EagerInitialization() {}
    public static EagerInitialization getInstance() {
        return INSTANCE;
    }
}
