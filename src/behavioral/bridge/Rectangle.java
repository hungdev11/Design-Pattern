package behavioral.bridge;

public class Rectangle extends Shape{
    public Rectangle(Drawing drawing) {
        super(drawing);
    }
    @Override
    protected void drawShape(int x, int y, String color) {
        System.out.println("RECTANGLE");
        drawing.draw(x, y, color);
    }
}
