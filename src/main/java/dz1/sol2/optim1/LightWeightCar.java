package dz1.sol2.optim1;

public class LightWeightCar extends Car {
    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
