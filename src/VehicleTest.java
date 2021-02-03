


/**
 * TestVehicles oppretter Bicycle og Car objekter, legger disse i et ArrayList
 * Lar bruker manipulere data i arrayet på forskjellige måter
 */

import java.util.*;
import java.io.*;

public class VehicleTest {
  public static void main(String[] args) {
	  VehicleTest vtest = new VehicleTest();
    try {
      vtest.menuLoop();
    } catch(IOException e) {
      System.out.println("IO Exception!");
      System.exit(1);
    } catch(CloneNotSupportedException e) {
      System.out.println("CloneNotSupportedException");
      System.exit(1);
    }
  }

  private void menuLoop() throws IOException, CloneNotSupportedException {
    Scanner scan = new Scanner(System.in);
    ArrayList<Vehicle> arr=new ArrayList<Vehicle>();
    Vehicle vehicle;

    arr.add(new Car("Volvo","Black",85000,2010,"1010-11",163,0));
    arr.add(new Bicycle("Diamant","yellow",4000,1993,"BC100",10,0));
    arr.add(new Car("Ferrari Testarossa","red",1200000,1996,"A112",350,0));
    arr.add(new Bicycle("DBS","pink",5000,1994,"42",10,0));



    while(true) {
      System.out.println("1...................................New car");
      System.out.println("2...............................New bicycle");
      System.out.println("3......................Find vehicle by name");
      System.out.println("4..............Show data about all vehicles");
      System.out.println("5.......Change direction of a given vehicle");
      System.out.println("6.........................Test clone method");
      System.out.println("7..............................Exit program");
      System.out.println(".............................Your choice?");
      int choice = scan.nextInt();

      switch (choice) {
      case 1:
        //legg til en ny bil
        Car newCar = new Car();
        newCar.setAllFields();
        arr.add(newCar);

        break;
      case 2:
        //legg til en ny sykkel
        Bicycle newBicycle = new Bicycle();
        newBicycle.setAllFields();
        arr.add(newBicycle);

        break;
      case 3:
        //vis info om gitt kjøretøy
        Scanner input = new Scanner(System.in);
        System.out.print("\nSearch: ");
        String searchInfo = input.next();


        int count = 0;
        for (Vehicle result : arr) {
          if (result.toString().contains(searchInfo)) {
            System.out.println(result.toString() + "\n");
            count = +1;
          }
          }if (count == 0) {
            System.out.println("This vehicle does not exist...\n");
        }


        break;
      case 4:
        //vis info om alle kjøretøy
        arr.forEach((infoVehicle) -> {
          System.out.println(infoVehicle.toString());
        });
        break;
      case 5:
        // Finn kjøretøy med gitt navn, sett ny retning
        input = new Scanner(System.in);
        System.out.print("\nSearch for given vehicle: ");
        String vehicleName = input.next();

        for (Vehicle result : arr) {
          if (result.getName().equals(vehicleName)) {

            System.out.println("Direction [R/L]: ");
            char inputDirection = Character.toUpperCase(input.next().charAt(0));
            char r = Character.toUpperCase('R');
            char l = Character.toUpperCase('L');


            if (inputDirection == r) {
              System.out.println("Degress [0-360]: ");
              int rightDirection = input.nextInt();
              result.turnRight(rightDirection);
            }

              else if (inputDirection == l) {
                System.out.println("Degress [0-360]: ");
                int leftDirection = input.nextInt();
                result.turnLeft(leftDirection);
              }

            else {
                System.out.println("Invalid direction...\n");
              }
          }
          }
        break;
        case 6:
          //clone

          break;
      case 7:
      	scan.close();
        System.exit(0);
      default:
        System.out.println("Wrong input!");
      }
    }
  }
}

