package creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Singleton is a creational design pattern that help you ensure that a class
 * has only one instance and provide a global access point to this instance
 */
public class Singleton {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        BreakByReflection.breakSingleton();
    }
}
// easy but easy to break by reflection
class EagerInitialization {
    private static final EagerInitialization INSTANCE = new EagerInitialization();
    private EagerInitialization(){}
    public static EagerInitialization getInstance(){
        return INSTANCE;
    }
}
// similar to eager initialization but adding static block for handle exception or some preprocess
class StaticBlockInitialization {
    private static final StaticBlockInitialization INSTANCE;
    static {
        try {
            INSTANCE = new StaticBlockInitialization();
        } catch (Exception e) {
            throw new RuntimeException("Something wrong with initialization");
        }
    }
    private StaticBlockInitialization(){}
    public static StaticBlockInitialization getInstance() {
        return INSTANCE;
    }
}
/**
 * work well in single thread environment but get slow to create instance in the first use
 */
class LazyInitialization {
    private static LazyInitialization instance;
    private LazyInitialization() {};
    public static LazyInitialization getInstance() {
        if (instance == null) {
            return new LazyInitialization();
        }
        return instance;
    }
}
// one thread get instance at that time,
// but it's slow when some thread already use
// some task no need to block
class ThreadSafeInitialization {
    //violate means that variable notifies to all thread if it changes the value
    private static volatile ThreadSafeInitialization instance;
    private ThreadSafeInitialization(){}
    public static synchronized ThreadSafeInitialization getInstance() {
        if (instance == null) return new ThreadSafeInitialization();
        return instance;
    }
}

/**
 * check instance existence, allow other thread do something before get instance
 */
class DoubleCheckInitialization {
    private static volatile DoubleCheckInitialization instance;
    private DoubleCheckInitialization(){}
    public static DoubleCheckInitialization getInstance() {
        //Do something before get instance
        if (instance == null) {
            // Do the task too long before create instance ...
            // Block so other threads cannot come into while initialize
            synchronized (DoubleCheckInitialization.class) {
                // Re-check again. Maybe another thread has initialized before
                // Scenario when a thread go in and just in time another thread created a instance
                if (instance == null) {
                    return new DoubleCheckInitialization();
                }
            }
        }
        //Do something after get instance
        return instance;
    }
}
/**
 * distinct function of class helper create instance, main class get instance
 * When main class load helper class not load yet, it loads when getInstance() is called
 * This way is the best cuz it has good performance by separate handle process
 * avoid initialization error mechanism in multi-thread
 */
class BillBughImplementation {
    private BillBughImplementation(){}
    public static BillBughImplementation getInstance() {
        return BillPughHelper.INSTANCE;
    }
    private static class BillPughHelper {
        private static final BillBughImplementation INSTANCE = new BillBughImplementation();
    }
}
/**
 * Eager and Bill Pugh can be break by reflection
 */
class BreakByReflection {
    public static void breakSingleton() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        EagerInitialization one = EagerInitialization.getInstance();
        EagerInitialization two = null;

        Constructor<?>[] constructors = EagerInitialization.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            two = (EagerInitialization) constructor.newInstance();
        }
        System.out.println(one.hashCode());
        System.out.println(two.hashCode());
    }
}
/**
 * Enum singleton
 * cons: can't extend
 * enum's constructor is lazy, init only when use and only one time
 * eager if execute in a static block when start application
 * enum solve Serialize/ Deserialize problem
 */
enum EnumSingleton {
    INSTANCE
}
