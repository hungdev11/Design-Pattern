package creational.singleton;

import java.util.Objects;

// have bad performance cuz lock entire method, thread access later can do something else first, use double check locking when have
// some pre/later processes
public class Locking {
    private static volatile Locking instance;
    private Locking() {}
    public static synchronized Locking getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Locking();
        }
        return new Locking();
    }
}
