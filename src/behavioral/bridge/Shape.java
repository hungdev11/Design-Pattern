package behavioral.bridge;

public abstract class Shape {
    protected Drawing drawing;
    protected Shape(Drawing drawing) {
        this.drawing = drawing;
    }
    protected abstract void drawShape(int x, int y, String color);
}
