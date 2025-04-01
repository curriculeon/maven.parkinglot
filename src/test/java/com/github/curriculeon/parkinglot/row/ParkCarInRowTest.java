package com.github.curriculeon.parkinglot.row;

import org.junit.Test;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingCell;
import com.github.curriculeon.parkinglot.ParkingRow;
import com.github.curriculeon.parkinglot.Size;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class ParkCarInRowTest {
    
    @Test
    public void testParkCarInFirstAvailableSpot() {
        // Given
        final List<ParkingCell> cells = Arrays.asList(
            new ParkingCell(Size.SMALL),
            new ParkingCell(Size.MEDIUM),
            new ParkingCell(Size.LARGE)
        );
        final ParkingRow row = new ParkingRow(cells);
        final Car car = new Car(Size.SMALL);
        
        // When
        final boolean result = row.parkCar(car);
        
        // Then
        assertTrue("Should be able to park car in first available spot", result);
        assertTrue("First spot should be occupied", cells.get(0).isOccupied());
    }

    @Test
    public void testParkCarInSecondSpot() {
        // Given
        final List<ParkingCell> cells = Arrays.asList(
            new ParkingCell(Size.SMALL),
            new ParkingCell(Size.MEDIUM),
            new ParkingCell(Size.LARGE)
        );
        final ParkingRow row = new ParkingRow(cells);
        final Car car1 = new Car(Size.SMALL);
        final Car car2 = new Car(Size.MEDIUM);
        
        // When
        row.parkCar(car1);
        final boolean result = row.parkCar(car2);
        
        // Then
        assertTrue("Should be able to park car in second spot", result);
        assertTrue("Second spot should be occupied", cells.get(1).isOccupied());
    }

    @Test
    public void testParkCarWhenNoSuitableSpotAvailable() {
        // Given
        final List<ParkingCell> cells = Arrays.asList(
            new ParkingCell(Size.SMALL),
            new ParkingCell(Size.SMALL),
            new ParkingCell(Size.SMALL)
        );
        final ParkingRow row = new ParkingRow(cells);
        final Car car = new Car(Size.LARGE);
        
        // When
        final boolean result = row.parkCar(car);
        
        // Then
        assertFalse("Should not be able to park large car when no suitable spot available", result);
    }

    @Test
    public void testParkCarWhenAllSpotsOccupied() {
        // Given
        final List<ParkingCell> cells = Arrays.asList(
            new ParkingCell(Size.MEDIUM),
            new ParkingCell(Size.MEDIUM),
            new ParkingCell(Size.MEDIUM)
        );
        final ParkingRow row = new ParkingRow(cells);
        final Car car1 = new Car(Size.SMALL);
        final Car car2 = new Car(Size.SMALL);
        final Car car3 = new Car(Size.SMALL);
        final Car car4 = new Car(Size.SMALL);
        
        // When
        row.parkCar(car1);
        row.parkCar(car2);
        row.parkCar(car3);
        final boolean result = row.parkCar(car4);
        
        // Then
        assertFalse("Should not be able to park car when all spots are occupied", result);
    }
} 