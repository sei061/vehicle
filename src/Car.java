
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Car extends Vehicle {
    private int power;
    private Calendar productionDate = Calendar.getInstance ();
    SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");

    public Car() {

    }

    public Car(String name, String colour, int price, int model, String serialNumber, int direction, int power) {
        super(name, colour, price, model, serialNumber, direction);
        this.power = power;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Car(int power) {
        this.power = power;
    }

    @Override
    public void setAllFields() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Input car data: ");
            super.setAllFields();
            System.out.print("Power: ");
            this.power = input.nextInt();
            System.out.println();

        } catch (Exception mismatch) {
            System.out.println("\nError! Wrong input type...");
            System.exit(0);
        }
    }

    @Override
    public void turnRight(int degrees) {
        setDirection((getDirection() + degrees) % 360);
    }

    @Override
    public void turnLeft(int degrees) {
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
                ", power:" + power +
                ", production date: " + (sdf.format(productionDate.getTime()));
    }
}


