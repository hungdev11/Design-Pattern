package creational.prototype;

public class Ram implements Cloneable {
    private String brand;
    private int capacityInGB;
    public Ram(String b, int c) {
        brand = b;
        capacityInGB = c;
    }
    @Override
    public String toString() {
        return "Ram: " + brand + " ," + capacityInGB;
    }
    @Override
    public Ram clone() { // Deep copy if it called, shallow otherwise
        try {
            return (Ram) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed!", e);
        }
    }
}
