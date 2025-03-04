package behavioral.bridge;

public class Client {
    public static void main(String[] args) {
        Shape round = new Round(new DrawBottom());
        round.drawShape(10, 20, "RED");

        Shape rectangle = new Rectangle(new DrawTop());
        rectangle.drawShape(10, 20, "BLACK");
    }
}
