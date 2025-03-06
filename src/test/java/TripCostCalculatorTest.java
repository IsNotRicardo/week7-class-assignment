import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

public class TripCostCalculatorTest {
    private TripCostCalculator tripCostCalculator;

    @BeforeEach
    void setUp() {
        tripCostCalculator = new TripCostCalculator();
    }

    @Test
    void testDefaultFuelPrice() {
        assertEquals(0, tripCostCalculator.getFuelPrice(), 0);
    }

    @Test
    void testSetFuelPrice() {
        tripCostCalculator.setFuelPrice(1.5);
        assertEquals(1.5, tripCostCalculator.getFuelPrice(), 0);
    }

    @Test
    void testSetFuelPriceInvalid() {
        try {
            tripCostCalculator.setFuelPrice(-2);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Fuel price must be greater than 0", e.getMessage());
        }
    }

    @Test
    void testCalculateTripCost() {
        tripCostCalculator.setFuelPrice(1.5);
        assertEquals(7.5, tripCostCalculator.calculateTripCost(100), 0);
    }

    @Test
    void testCalculateTripCostInvalid() {
        try {
            tripCostCalculator.calculateTripCost(-100);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Distance must be greater than 0", e.getMessage());
        }

        try {
            tripCostCalculator.calculateTripCost(100);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("You must define a fuel price before", e.getMessage());
        }
    }
}
