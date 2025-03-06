import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TripCostCalculator tripCostCalculator = new TripCostCalculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTrip Cost Calculator\n");
            System.out.println("1. Set fuel price");
            System.out.println("2. Calculate trip cost");
            System.out.println("3. Exit");

            System.out.print("\nChoose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Enter the fuel price: ");
                    double fuelPrice = Double.parseDouble(scanner.nextLine());

                    try {
                        tripCostCalculator.setFuelPrice(fuelPrice);
                        System.out.println("Fuel price set successfully");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter the distance: ");
                    double distance = Double.parseDouble(scanner.nextLine());

                    try {
                        double tripCost = tripCostCalculator.calculateTripCost(distance);
                        System.out.println("Trip cost: " + tripCost + "€");
                        System.out.println("Fuel price: " + tripCostCalculator.getFuelPrice() + "€/L");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
