package dz1.sol3;

public class Regtangle extends Figure {
    private double sideA;
    private double sideB;

    public Regtangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double square() {
        return sideA*sideB;
    }

    @Override
    public TypeFigure getType() {
        return TypeFigure.RECTANGLE;
    }
}
