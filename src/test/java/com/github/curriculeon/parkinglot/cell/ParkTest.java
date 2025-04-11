package com.github.curriculeon.parkinglot.cell;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingSpot;
import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParkTest {
    
    @Test
    public void testParkCarInEmptySpot() {
        // Given
        final ParkingSpot cell = new ParkingSpot(CarSize.MEDIUM);
        final Car car = new Car(CarSize.SMALL);
        
        // When
        final boolean result = cell.park(car);
        
        // Then
        assertTrue("Should be able to park car in empty spot", result);
        assertTrue("Spot should be occupied after parking", cell.isOccupied());
    }

    @Test
    public void testParkCarInOccupiedSpot() {
        // Given
        final ParkingSpot cell = new ParkingSpot(CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.SMALL);
        
        // When
        cell.park(car1);
        final boolean result = cell.park(car2);
        
        // Then
        assertFalse("Should not be able to park car in occupied spot", result);
    }

    @Test
    public void testParkCarThatDoesNotFit() {
        // Given
        final ParkingSpot cell = new ParkingSpot(CarSize.SMALL);
        final Car car = new Car(CarSize.LARGE);
        
        // When
        final boolean result = cell.park(car);
        
        // Then
        assertFalse("Should not be able to park car that doesn't fit", result);
        assertFalse("Spot should remain unoccupied", cell.isOccupied());
    }

    @Test
    public void testParkCarInSameSizeSpot() {
        // Given
        final ParkingSpot cell = new ParkingSpot(CarSize.MEDIUM);
        final Car car = new Car(CarSize.MEDIUM);
        
        // When
        final boolean result = cell.park(car);
        
        // Then
        assertTrue("Should be able to park car in same size spot", result);
        assertTrue("Spot should be occupied after parking", cell.isOccupied());
    }

    @Test
    public void testParkCarInLargerSpot() {
        // Given
        final ParkingSpot cell = new ParkingSpot(CarSize.LARGE);
        final Car car = new Car(CarSize.SMALL);
        
        // When
        final boolean result = cell.park(car);
        
        // Then
        assertTrue("Should be able to park car in larger spot", result);
        assertTrue("Spot should be occupied after parking", cell.isOccupied());
    }
} 