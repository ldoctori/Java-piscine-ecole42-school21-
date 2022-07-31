package classes;

import java.util.StringJoiner;

public class Car {

    private String make;
    private String model;
    private int horsePower;

    public Car() {
        this.make = "Lada";
        this.model = "sedan-baklojan";
        this.horsePower = 3;
    }

    public Car(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public int pumping(int value) {
        this.horsePower += value;
        return horsePower;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("make='" + make + "'")
                .add("model='" + model + "'")
                .add("horsePower=" + horsePower)
                .toString();
    }

}
