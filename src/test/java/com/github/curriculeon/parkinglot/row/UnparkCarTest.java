package com.github.curriculeon.parkinglot.row;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingRow;
import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnparkCarTest {
    
    @Test
    public void testUnparkCarFromOccupiedSpot() {
        // Given
        final ParkingRow row = new ParkingRow(3, CarSize.MEDIUM);
        final Car car = new Car(CarSize.SMALL);
        row.parkCar(car);
        
        // When
        final Car unparkedCar = row.unparkCar(0);
        
        // Then
        assertNotNull("Unparked car should not be null", unparkedCar);
        assertEquals("Unparked car should be the same as parked car", car, unparkedCar);
        assertFalse("Spot should be unoccupied after unparking", row.getCell(0).isOccupied());
    }

    @Test
    public void testUnparkCarFromEmptySpot() {
        // Given
        final ParkingRow row = new ParkingRow(3, CarSize.MEDIUM);
        
        // When
        final Car unparkedCar = row.unparkCar(0);
        
        // Then
        assertNull("Unparked car should be null from empty spot", unparkedCar);
        assertFalse("Spot should remain unoccupied", row.getCell(0).isOccupied());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnparkCarFromInvalidIndex() {
        // Given
        final ParkingRow row = new ParkingRow(3, CarSize.MEDIUM);
        
        // When
        final Car unparkedCar = row.unparkCar(5);
        
        // Then
        assertNull("Unparked car should be null from invalid index", unparkedCar);
    }

    @Test
    public void testUnparkCarFromOccupiedSpotInMiddle() {
        // Given
        final ParkingRow row = new ParkingRow(3, CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.SMALL);
        row.parkCar(car1);
        row.parkCar(car2);
        
        // When
        final Car unparkedCar = row.unparkCar(1);
        
        // Then
        assertNotNull("Unparked car should not be null", unparkedCar);
        assertEquals("Unparked car should be the same as parked car", car2, unparkedCar);
        assertFalse("Spot should be unoccupied after unparking", row.getCell(1).isOccupied());
        assertTrue("First spot should remain occupied", row.getCell(0).isOccupied());
    }
} 