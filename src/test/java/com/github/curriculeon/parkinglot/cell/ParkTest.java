package com.github.curriculeon.parkinglot.cell;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingCell;
import com.github.curriculeon.parkinglot.Size;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParkTest {
    
    @Test
    public void testParkCarInEmptySpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.MEDIUM);
        final Car car = new Car(Size.SMALL);
        
        // When
        final boolean result = cell.park(car);
        
        // Then
        assertTrue("Should be able to park car in empty spot", result);
        assertTrue("Spot should be occupied after parking", cell.isOccupied());
    }

    @Test
    public void testParkCarInOccupiedSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.MEDIUM);
        final Car car1 = new Car(Size.SMALL);
        final Car car2 = new Car(Size.SMALL);
        
        // When
        cell.park(car1);
        final boolean result = cell.park(car2);
        
        // Then
        assertFalse("Should not be able to park car in occupied spot", result);
    }

    @Test
    public void testParkCarThatDoesNotFit() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.SMALL);
        final Car car = new Car(Size.LARGE);
        
        // When
        final boolean result = cell.park(car);
        
        // Then
        assertFalse("Should not be able to park car that doesn't fit", result);
        assertFalse("Spot should remain unoccupied", cell.isOccupied());
    }

    @Test
    public void testParkCarInSameSizeSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.MEDIUM);
        final Car car = new Car(Size.MEDIUM);
        
        // When
        final boolean result = cell.park(car);
        
        // Then
        assertTrue("Should be able to park car in same size spot", result);
        assertTrue("Spot should be occupied after parking", cell.isOccupied());
    }

    @Test
    public void testParkCarInLargerSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.LARGE);
        final Car car = new Car(Size.SMALL);
        
        // When
        final boolean result = cell.park(car);
        
        // Then
        assertTrue("Should be able to park car in larger spot", result);
        assertTrue("Spot should be occupied after parking", cell.isOccupied());
    }
} 