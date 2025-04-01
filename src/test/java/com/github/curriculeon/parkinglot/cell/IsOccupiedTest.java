package com.github.curriculeon.parkinglot.cell;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingCell;
import com.github.curriculeon.parkinglot.Size;
import org.junit.Test;
import static org.junit.Assert.*;

public class IsOccupiedTest {
    
    @Test
    public void testNewSpotIsNotOccupied() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.MEDIUM);
        
        // When
        final boolean isOccupied = cell.isOccupied();
        
        // Then
        assertFalse("New spot should not be occupied", isOccupied);
    }

    @Test
    public void testSpotIsOccupiedAfterParking() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.MEDIUM);
        final Car car = new Car(Size.SMALL);
        cell.park(car);
        
        // When
        final boolean isOccupied = cell.isOccupied();
        
        // Then
        assertTrue("Spot should be occupied after parking", isOccupied);
    }

    @Test
    public void testSpotIsNotOccupiedAfterUnparking() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.MEDIUM);
        final Car car = new Car(Size.SMALL);
        cell.park(car);
        cell.unparkCar();
        
        // When
        final boolean isOccupied = cell.isOccupied();
        
        // Then
        assertFalse("Spot should not be occupied after unparking", isOccupied);
    }

    @Test
    public void testSpotRemainsUnoccupiedAfterFailedPark() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.SMALL);
        final Car car = new Car(Size.LARGE);
        cell.park(car);
        
        // When
        final boolean isOccupied = cell.isOccupied();
        
        // Then
        assertFalse("Spot should remain unoccupied after failed park", isOccupied);
    }
} 