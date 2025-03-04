package behavioral.bridge;

public class DrawTop extends Drawing {
    @Override
    protected void draw(int x, int y, String color) {
        System.out.println("TOP");
        super.draw(x, y, color);
    }
}

