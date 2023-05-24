import java.util.Scanner;

public class Elevator {
    int currentFloor;
    int numFloors;
    int currentPassengers;
    int maxPassengers;

    public Elevator(int numFloors, int maxPassengers) {
        this.currentFloor = 1;
        this.numFloors = numFloors;
        this.currentPassengers = 0;
        this.maxPassengers = maxPassengers;
    }

    public void moveUp() {
        if (currentFloor < numFloors)
            currentFloor++;
    }

    public void moveDown() {
        if (currentFloor > 0)
            currentFloor--;
    }

    // Return true if the elevator can accept passengers
    public boolean acceptPassengers(int num) {
        boolean result = true;
        int availableSpace = maxPassengers - currentPassengers;
        if (availableSpace > 0 && num > 0) {
            if (availableSpace >= num) {
                currentPassengers += num;
            } else {
                currentPassengers += availableSpace;
            }
        } else {
            result = false;
        }
        return result;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of floors: ");
        int numFloors = scanner.nextInt();

        System.out.print("Enter the maximum number of passengers: ");
        int maxPassengers = scanner.nextInt();

        Elevator elevator = new Elevator(numFloors, maxPassengers);

        System.out.println("Elevator initialized.");
        System.out.println("Current floor: " + elevator.getCurrentFloor());

        while (true) {
            System.out.print("Enter 'u' to move up, 'd' to move down, 'p' to accept passengers, or 'q' to quit: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("u")) {
                elevator.moveUp();
                System.out.println("Moving up to floor " + elevator.getCurrentFloor());
            } else if (input.equalsIgnoreCase("d")) {
                elevator.moveDown();
                System.out.println("Moving down to floor " + elevator.getCurrentFloor());
            } else if (input.equalsIgnoreCase("p")) {
                System.out.print("Enter the number of passengers: ");
                int numPassengers = scanner.nextInt();

                boolean accepted = elevator.acceptPassengers(numPassengers);
                if (accepted) {
                    System.out.println("Passengers accepted. Current passenger count: " + elevator.currentPassengers);
                } else {
                    System.out.println("Passengers not accepted. Elevator is at maximum capacity.");
                }
            } else if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting elevator program.");
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
    }
}