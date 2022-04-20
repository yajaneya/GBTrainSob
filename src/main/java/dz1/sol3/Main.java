package dz1.sol3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Figure> figures = new ArrayList<>();

        Circle circle = new Circle(5);
        Square square = new Square(5);
        Regtangle regtangle = new Regtangle(5, 15);

        figures.add(circle);
        figures.add(square);
        figures.add(regtangle);

        for (Figure figure : figures) {
            System.out.println(figure.getType() + " -> площадь: " + figure.square());
        }

    }
}
