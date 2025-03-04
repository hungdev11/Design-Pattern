package behavioral.bridge;

public class DrawBottom extends Drawing {
    @Override
    protected void draw(int x, int y, String color) {
        System.out.println("BOTTOM");
        super.draw(x, y, color);
    }
}

