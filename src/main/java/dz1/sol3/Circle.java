package dz1.sol3;

public class Circle implements Figure{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return 3.14*3.14*radius;
    }

    @Override
    public TypeFigure getType() {
        return TypeFigure.CIRCLE;
    }
}
