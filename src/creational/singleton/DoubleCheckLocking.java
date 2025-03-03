package creational.singleton;

import java.util.Objects;

public class DoubleCheckLocking {
    private static volatile DoubleCheckLocking instance;
    private DoubleCheckLocking() {}
    public static DoubleCheckLocking getInstance() {
        // do something
        if (Objects.isNull(instance)) {
            // do something
            // double check if a thread is going here and another thread already init the instance
            synchronized (DoubleCheckLocking.class) {
                if (Objects.isNull(instance)) {
                    instance = new DoubleCheckLocking();
                }
            }
        }
        return instance;
    }
}
