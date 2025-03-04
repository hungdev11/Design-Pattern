package behavioral.bridge;

public abstract class Drawing {
    protected void draw(int x, int y, String color) {
        System.out.println(x + " " + y  + " " + color);
    }
}
