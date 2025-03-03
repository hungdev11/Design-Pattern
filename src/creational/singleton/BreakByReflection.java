package creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Except enum, almost singleton can be break by reflection
public class BreakByReflection {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        EagerInitialization instance1 = EagerInitialization.getInstance();
        EagerInitialization instance2 = null;
        Constructor<?>[] constructors = EagerInitialization.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            instance2 = (EagerInitialization) constructor.newInstance();
        }
        System.out.println(instance1 == instance2);
    }
}
