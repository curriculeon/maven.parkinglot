package com.github.curriculeon.parkinglot.cell;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingCell;
import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnparkTest {
    
    @Test
    public void testUnparkFromOccupiedSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(CarSize.MEDIUM);
        final Car car = new Car(CarSize.SMALL);
        cell.park(car);
        
        // When
        final Car unparkedCar = cell.unparkCar();
        
        // Then
        assertNotNull("Unparked car should not be null", unparkedCar);
        assertEquals("Unparked car should be the same as parked car", car, unparkedCar);
        assertFalse("Spot should be unoccupied after unparking", cell.isOccupied());
    }

    @Test
    public void testUnparkFromEmptySpot() {
        // Given
        final ParkingCell cell = new ParkingCell(CarSize.MEDIUM);
        
        // When
        final Car unparkedCar = cell.unparkCar();
        
        // Then
        assertNull("Unparked car should be null from empty spot", unparkedCar);
        assertFalse("Spot should remain unoccupied", cell.isOccupied());
    }

    @Test
    public void testUnparkMultipleTimes() {
        // Given
        final ParkingCell cell = new ParkingCell(CarSize.MEDIUM);
        final Car car = new Car(CarSize.SMALL);
        cell.park(car);
        
        // When
        final Car firstUnpark = cell.unparkCar();
        final Car secondUnpark = cell.unparkCar();
        
        // Then
        assertNotNull("First unpark should return the car", firstUnpark);
        assertEquals("First unpark should return the correct car", car, firstUnpark);
        assertNull("Second unpark should return null", secondUnpark);
        assertFalse("Spot should be unoccupied after unparking", cell.isOccupied());
    }
} 