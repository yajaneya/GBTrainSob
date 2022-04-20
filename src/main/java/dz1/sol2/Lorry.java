package dz1.sol2;

public class Lorry extends Car implements Moveable, Stopable{ //public class Lorry extends Car, Moveable, Stopable{
    public void move() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car is stop");
    }

    // метод отсутствовал
    public void open() {
        System.out.println("Car is open");
    }
}
