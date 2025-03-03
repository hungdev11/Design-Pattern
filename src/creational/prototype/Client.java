package creational.prototype;

public class Client {
    public static void main(String[] args) {
        Computer computer1 = new EliteBook845G10(new Ram("Leopard", 8), "Hp elitebook 845 gen 10", new SSD());
        computer1.info();

        Computer computer2 = computer1.clone();
        computer2.info();

        // Check if the objects are different
        System.out.println("Same Computer object? " + (computer2 == computer1)); // false ✅
        System.out.println("Same RAM object? " + (computer2.getRam() == computer1.getRam())); // false ✅
        System.out.println("Same SSD object? " + (computer2.getSsd() == computer1.getSsd())); // false ✅
    }
}

