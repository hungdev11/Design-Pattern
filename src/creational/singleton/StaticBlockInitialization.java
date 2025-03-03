package creational.singleton;

// similar to Eager initialization, addition handle exception or process something else
public class StaticBlockInitialization {
    private static final StaticBlockInitialization INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockInitialization();
        } catch (Exception e) { // Something go wrong when JVM creating the instance
            throw new RuntimeException("Something go wrong when creating an instance");
        }
    }

    private StaticBlockInitialization(){}
    public static StaticBlockInitialization getInstance(){
        return INSTANCE;
    }
}
