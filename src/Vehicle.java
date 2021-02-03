

import java.util.Scanner;

public abstract class Vehicle {
    private String colour, name, serialNumber;
    private int model, price, direction = 0;
    private double speed = 0;

    protected java.util.Scanner input;

    public Vehicle() {

    }

    public Vehicle(String name, String colour, int price, int model, String serialNumber, int direction) {
        this.name = name;
        this.colour = colour;
        this.price = price;
        this.model = model;
        this.serialNumber = serialNumber;
        this.direction = direction;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setAllFields() {
            Scanner input = new Scanner(System.in);

            System.out.print("Name: ");
            this.name = input.next();

            System.out.print("Colour: ");
            this.colour = input.next();

            System.out.print("Price: ");
            this.price = input.nextInt();

            System.out.print("Model: ");
            this.model = input.nextInt();

            System.out.print("Serial #: ");
            this.serialNumber = input.next();
    }


    public abstract void turnLeft (int degrees);

    public abstract void turnRight (int degrees);

    @Override
    public String toString() {
        return  "Name: '" + name + '\'' +
                ", colour: '" + colour + '\'' +
                ", serialNumber: '" + serialNumber + '\'' +
                ", model: " + model +
                ", price: " + price +
                ", direction: " + direction +
                ", speed: " + speed;
    }
}
