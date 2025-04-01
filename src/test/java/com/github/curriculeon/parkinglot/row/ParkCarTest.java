package com.github.curriculeon.parkinglot.row;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingRow;
import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParkCarTest {
    
    @Test
    public void testParkCarInEmptyRow() {
        // Given
        final ParkingRow row = new ParkingRow(3, CarSize.MEDIUM);
        final Car car = new Car(CarSize.SMALL);
        
        // When
        final boolean result = row.parkCar(car) != null;
        
        // Then
        assertTrue("Should be able to park car in empty row", result);
        assertTrue("First spot should be occupied", row.getCell(0).isOccupied());
    }

    @Test
    public void testParkCarInFullRow() {
        // Given
        final ParkingRow row = new ParkingRow(2, CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.SMALL);
        final Car car3 = new Car(CarSize.SMALL);
        
        // When
        row.parkCar(car1);
        row.parkCar(car2);
        final boolean result = row.parkCar(car3) != null;
        
        // Then
        assertFalse("Should not be able to park car in full row", result);
    }

    @Test
    public void testParkCarThatDoesNotFit() {
        // Given
        final ParkingRow row = new ParkingRow(3, CarSize.SMALL);
        final Car car = new Car(CarSize.LARGE);
        
        // When
        final boolean result = row.parkCar(car) != null;
        
        // Then
        assertFalse("Should not be able to park car that doesn't fit", result);
        assertFalse("First spot should remain unoccupied", row.getCell(0).isOccupied());
    }

    @Test
    public void testParkCarInNextAvailableSpot() {
        // Given
        final ParkingRow row = new ParkingRow(3, CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.SMALL);
        
        // When
        row.parkCar(car1);
        final boolean result = row.parkCar(car2) != null;
        
        // Then
        assertTrue("Should be able to park car in next available spot", result);
        assertTrue("Second spot should be occupied", row.getCell(1).isOccupied());
    }
} 