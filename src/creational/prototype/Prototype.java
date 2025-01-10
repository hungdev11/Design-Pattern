package creational.prototype;

/**
 * Prototype is the final creational pattern that provide new object with attributes are similar with existed object
 * and 2 objects are distinct and reference object fields are also distinct.
 * Implements Cloneable notify JVM to reuse existed object instead create a new one
 */
public class Prototype {
    public static void main(String[] args) {
        Computer com1 = new Computer("Window", "Bkav", "365", "Android studio");
        Computer com2 = com1.clone();
        com2.setOrthers("IntelliJ IDE");
        System.out.println(com1);
        System.out.println(com2);
    }
}
class Computer implements Cloneable{
    private String os;
    private String antivirus;
    private String office;
    private String others; // additional option for cloned object
    public Computer(String os, String antivirus, String office, String others) {
        this.os = os;
        this.antivirus = antivirus;
        this.office = office;
        this.others = others;
    }

    @Override
    public Computer clone() {
        try {
            Computer clone = (Computer) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "os='" + os + '\'' +
                ", antivirus='" + antivirus + '\'' +
                ", office='" + office + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public void setOrthers(String others) {
        this.others = others;
    }
}
