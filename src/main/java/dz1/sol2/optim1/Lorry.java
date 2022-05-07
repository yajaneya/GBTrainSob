package dz1.sol2.optim1;

public class Lorry extends Car implements Stopable {
    public void move() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car is stop");
    }

    public void open() {
        System.out.println("Car is open");
    }
}
