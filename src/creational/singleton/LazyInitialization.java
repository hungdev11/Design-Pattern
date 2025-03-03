package creational.singleton;

import java.util.Objects;

// create instance when u want to get and use the instance, can break by reflection, good in single thread environment
public class LazyInitialization {
    private static LazyInitialization instance;
    private LazyInitialization() {}
    public static LazyInitialization getInstance() {
        if (Objects.isNull(instance)) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}
