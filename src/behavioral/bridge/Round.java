package behavioral.bridge;

public class Round extends Shape{
    public Round(Drawing drawing) {
        super(drawing);
    }
    @Override
    protected void drawShape(int x, int y, String color) {
        System.out.println("ROUND");
        drawing.draw(x, y, color);
    }
}
