package com.github.curriculeon.parkinglot.row;

import org.junit.Test;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingSpot;
import com.github.curriculeon.parkinglot.ParkingRow;
import com.github.curriculeon.parkinglot.CarSize;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class ParkCarInRowTest {
    
    @Test
    public void testParkCarInFirstAvailableSpot() {
        // Given
        final List<ParkingSpot> cells = Arrays.asList(
            new ParkingSpot(CarSize.SMALL),
            new ParkingSpot(CarSize.MEDIUM),
            new ParkingSpot(CarSize.LARGE)
        );
        final ParkingRow row = new ParkingRow(cells);
        final Car car = new Car(CarSize.SMALL);
        
        // When
        final boolean result = row.park(car) != null;
        
        // Then
        assertTrue("Should be able to park car in first available spot", result);
        assertTrue("First spot should be occupied", cells.get(0).isOccupied());
    }

    @Test
    public void testParkCarInSecondSpot() {
        // Given
        final List<ParkingSpot> cells = Arrays.asList(
            new ParkingSpot(CarSize.SMALL),
            new ParkingSpot(CarSize.MEDIUM),
            new ParkingSpot(CarSize.LARGE)
        );
        final ParkingRow row = new ParkingRow(cells);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.MEDIUM);
        
        // When
        row.park(car1);
        final boolean result = row.park(car2) != null;
        
        // Then
        assertTrue("Should be able to park car in second spot", result);
        assertTrue("Second spot should be occupied", cells.get(1).isOccupied());
    }

    @Test
    public void testParkCarWhenNoSuitableSpotAvailable() {
        // Given
        final List<ParkingSpot> cells = Arrays.asList(
            new ParkingSpot(CarSize.SMALL),
            new ParkingSpot(CarSize.SMALL),
            new ParkingSpot(CarSize.SMALL)
        );
        final ParkingRow row = new ParkingRow(cells);
        final Car car = new Car(CarSize.LARGE);
        
        // When
        final boolean result = row.park(car) != null;
        
        // Then
        assertFalse("Should not be able to park large car when no suitable spot available", result);
    }

    @Test
    public void testParkCarWhenAllSpotsOccupied() {
        // Given
        final ParkingRow row = new ParkingRow(3, CarSize.MEDIUM);
        for(ParkingSpot cell : row) {
            cell.park(new Car(CarSize.SMALL));
        }
        
        // When
        final boolean result = row.park(new Car(CarSize.SMALL)) != null;
        
        // Then
        assertFalse("Should not be able to park car when all spots are occupied", result);
    }
} 