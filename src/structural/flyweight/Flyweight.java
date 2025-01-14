package structural.flyweight;

import java.time.Duration;
import java.util.*;

/**
 * Flyweight design pattern lets us reuse objects are existing by storage them
 * or create new when can't find any object appropriate
 * Its help system more lite weight by sharing objects, when we need to create amount of objects
 * Flyweight objects are immutable
 */
public class Flyweight {
    private static List<ISoldier> soldiers = new ArrayList<>();
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        createSoldier(5, "Yuri", 1);
        createSoldier(5, "Spy", 1);
        createSoldier(3, "Spy", 3);
        createSoldier(2, "Yuri", 2);
        long endTime = System.currentTimeMillis();
        System.out.println("---");
        System.out.println("Total soldiers made : " + soldiers.size());
        System.out.println("Total time worked : " + Duration.ofMillis(endTime - startTime).getSeconds() + " seconds");
        System.out.println("Total type of soldiers made : " + SoldierFactory.getTotalOfSoldiers());
    }
    private static void createSoldier(int numberOfSoldier, String name, int star) {
        for (int i = 0; i < numberOfSoldier; i++) {
            Context start = new Context("Soldier" + soldiers.size(), star);
            ISoldier soldier = SoldierFactory.createSoldier(name);
            soldier.promote(start);
            soldiers.add(soldier);
        }
    }
}

/**
 * Flyweight
 */
interface ISoldier {
    void promote(Context context);
}
/**
 * Extrinsic State
 */
class Context {
    private String id;
    private int start;
    public Context (String id, int start) {
        this.id = id;
        this.start = start;
    }
    public String getId() {return this.id;}
    public int getStart() {return start;}
}
class Soldier implements ISoldier {
    private final String name; //Intrinsic State
    public Soldier (String name) {
        this.name = name;
    }
    @Override
    public void promote(Context context) {
        System.out.println(name + " " + context.getId() + " " + context.getStart());
    }
}
class SoldierFactory {
    private static final Map<String, ISoldier> cache = new HashMap<>();
    private SoldierFactory () {
        throw new IllegalStateException();
    }
    public static synchronized ISoldier createSoldier(String name) {
        ISoldier soldier = cache.get(name);
        if (Objects.isNull(soldier)) {
            waiting(3);
            soldier = new Soldier(name);
            cache.put(name, soldier);
        }
        return soldier;
    }
    public static synchronized int getTotalOfSoldiers() {
        return cache.size();
    }
    private static void waiting(int second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
