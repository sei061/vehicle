

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Bicycle extends Vehicle {
    private int gears;
    private Calendar productionDate = Calendar.getInstance ();
    SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");

    public Bicycle() {
    }

    public Bicycle(String name, String colour, int price, int model, String serialNumber, int direction, int gears) {
        super(name, colour, price, model, serialNumber, direction);
        this.gears = gears;
    }

    @Override
    public void setAllFields () {
        try {
        Scanner input = new Scanner(System.in);
        System.out.println("Input bike data: ");
        super.setAllFields();
        System.out.print("Gears: ");
        this.gears = input.nextInt();
        System.out.println();
        } catch (Exception mismatch) {
            System.out.println("\nError! Wrong input type...");
            System.exit(0);
        }

    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public void turnLeft(int degrees) {
        setDirection((getDirection() - degrees) % 360);
    }

    @Override
    public void turnRight(int degrees) {
        int checkDirection = (getDirection() - degrees);
        if (checkDirection < 0) {
            int newDirection = (360 + (checkDirection));
            setDirection(newDirection);
        }
        else setDirection(checkDirection);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", gears: " + gears +
                ", production date: " + (sdf.format(productionDate.getTime()));
    }
}
