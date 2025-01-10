package creational.prototype;

import java.util.HashMap;
import java.util.Map;

// Simulate chess board
public class CombineFactoryMethod {
    public static void main(String[] args) {
        Board board = new Board();
        board.print();
    }
}
enum Color {
    WHITE, BLACK
}
class Cell implements Cloneable {
    private String color;
    private String coordinate;
    public Cell (String color) {
        this.color = color;
    }
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "color=" + color +
                ", coordinate='" + coordinate + '\'' +
                '}';
    }

    @Override
    public Cell clone() {
        try {
            Cell clone = (Cell) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
class CellFactory {
    private static final Map<Color, Cell> CELL_CACHE = new HashMap<>();
    private CellFactory(){}
    public static Cell getCell(Color color) {
        if (!CELL_CACHE.containsKey(color)) {
            CELL_CACHE.put(color, new Cell(color.name()));
        }
        return CELL_CACHE.get(color).clone();
    }
}
class Board {
    private static final int ROW = 8;
    private static final int COL = 8;
    private Cell[][] board;
    public Board () {
        this.board = new Cell[ROW][COL];
        Cell cell = null;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                cell = ((i+j) % 2 == 0) ? CellFactory.getCell(Color.WHITE)
                        : CellFactory.getCell(Color.BLACK);
                cell.setCoordinate(i + "x" + j);
                board[i][j] = cell;
            }
        }
    }
    public void print() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.println(board[i][j]);
            }
            System.out.println();
        }
    }
}

