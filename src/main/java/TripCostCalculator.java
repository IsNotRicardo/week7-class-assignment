public class TripCostCalculator {
    private final static double FUEL_CONSUMPTION_PER_KM = 0.05;
    private double fuelPrice;

    public double calculateTripCost(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be greater than 0");
        }
        if (fuelPrice <= 0) {
            throw new IllegalArgumentException("You must define a fuel price before");
        }

        return distance * FUEL_CONSUMPTION_PER_KM * fuelPrice;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(double fuelPrice) {
        if (fuelPrice <= 0) {
            throw new IllegalArgumentException("Fuel price must be greater than 0");
        }

        this.fuelPrice = fuelPrice;
    }
}
