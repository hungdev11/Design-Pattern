package behavioral.flyweight;

public class Soldier implements ISoldier{
    private final String name;
    public Soldier(String n) {
        name = n;
        System.out.println("Soldier is created! - " + name);
    }
    @Override
    public void promote(Context context) {
        System.out.println(name + " " + context.getId() + " promoted " + context.getStar());
    }
}
