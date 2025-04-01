package com.github.curriculeon.parkinglot.matrix;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingLot;
import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParkCarTest {
    
    @Test
    public void testParkCarInEmptyMatrix() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 3, CarSize.MEDIUM);
        final Car car = new Car(CarSize.SMALL);
        
        // When
        final boolean result = matrix.parkCar(car) != null;
        
        // Then
        assertTrue("Should be able to park car in empty matrix", result);
        assertTrue("First spot in first row should be occupied", matrix.getRow(0).getCell(0).isOccupied());
    }

    @Test
    public void testParkCarInFullMatrix() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 2, CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.SMALL);
        final Car car3 = new Car(CarSize.SMALL);
        final Car car4 = new Car(CarSize.SMALL);
        final Car car5 = new Car(CarSize.SMALL);
        
        // When
        matrix.parkCar(car1);
        matrix.parkCar(car2);
        matrix.parkCar(car3);
        matrix.parkCar(car4);
        final boolean result = matrix.parkCar(car5) != null;
        
        // Then
        assertFalse("Should not be able to park car in full matrix", result);
    }

    @Test
    public void testParkCarThatDoesNotFit() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 3, CarSize.SMALL);
        final Car car = new Car(CarSize.LARGE);
        
        // When
        final boolean result = matrix.parkCar(car) != null;
        
        // Then
        assertFalse("Should not be able to park car that doesn't fit", result);
        assertFalse("First spot should remain unoccupied", matrix.getRow(0).getCell(0).isOccupied());
    }

    @Test
    public void testParkCarInNextAvailableRow() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 2, CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.SMALL);
        final Car car3 = new Car(CarSize.SMALL);
        
        // When
        matrix.parkCar(car1);
        matrix.parkCar(car2);
        final boolean result = matrix.parkCar(car3) != null;
        
        // Then
        assertTrue("Should be able to park car in next available row", result);
        assertTrue("First spot in second row should be occupied", matrix.getRow(1).getCell(0).isOccupied());
    }
} 