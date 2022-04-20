package dz1.sol3;

public class Square implements Figure{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double square() {
        return side*side;
    }

    @Override
    public TypeFigure getType() {
        return TypeFigure.SQUARE;
    }
}
