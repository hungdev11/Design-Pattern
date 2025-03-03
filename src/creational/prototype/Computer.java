package creational.prototype;

public abstract class Computer implements Cloneable {
    protected Ram ram;
    protected SSD ssd;
    protected String name;

    public SSD getSsd() {
        return ssd;
    }
    public Ram getRam() {
        return ram;
    }
    protected Computer(Ram ram, String name, SSD ssd) {
        this.name = name;
        this.ssd = ssd;
        this.ram = ram;
    }
    protected void info() {
        System.out.println("=======================");
        System.out.println(ram + " Computer: " + name);
    }

    @Override
    public Computer clone() {
        try {
            Computer cloned = (Computer) super.clone();
            cloned.ram = this.ram.clone(); // Deep Copy ✅
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed!", e);
        }
    }
}
