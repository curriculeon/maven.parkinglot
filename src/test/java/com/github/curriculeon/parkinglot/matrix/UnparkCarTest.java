package com.github.curriculeon.parkinglot.matrix;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingLot;
import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnparkCarTest {
    
    @Test
    public void testUnparkCarFromOccupiedSpot() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 3, CarSize.MEDIUM);
        final Car car = new Car(CarSize.SMALL);
        matrix.parkCar(car);
        
        // When
        final Car unparkedCar = matrix.unparkCar(0, 0);
        
        // Then
        assertNotNull("Unparked car should not be null", unparkedCar);
        assertEquals("Unparked car should be the same as parked car", car, unparkedCar);
        assertFalse("Spot should be unoccupied after unparking", matrix.getRow(0).getCell(0).isOccupied());
    }

    @Test
    public void testUnparkCarFromEmptySpot() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 3, CarSize.MEDIUM);
        
        // When
        final Car unparkedCar = matrix.unparkCar(0, 0);
        
        // Then
        assertNull("Unparked car should be null from empty spot", unparkedCar);
        assertFalse("Spot should remain unoccupied", matrix.getRow(0).getCell(0).isOccupied());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnparkCarFromInvalidIndices() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 3, CarSize.MEDIUM);
        
        // When
        final Car unparkedCar = matrix.unparkCar(5, 5);
        
        // Then
        assertNull("Unparked car should be null from invalid indices", unparkedCar);
    }

    @Test
    public void testUnparkCarFromOccupiedSpotInSecondRow() {
        // Given
        final ParkingLot matrix = new ParkingLot(2, 2, CarSize.MEDIUM);
        final Car car1 = new Car(CarSize.SMALL);
        final Car car2 = new Car(CarSize.SMALL);
        final Car car3 = new Car(CarSize.SMALL);
        matrix.parkCar(car1);
        matrix.parkCar(car2);
        matrix.parkCar(car3);
        
        // When
        final Car unparkedCar = matrix.unparkCar(1, 0);
        
        // Then
        assertNotNull("Unparked car should not be null", unparkedCar);
        assertEquals("Unparked car should be the same as parked car", car3, unparkedCar);
        assertFalse("Spot should be unoccupied after unparking", matrix.getRow(1).getCell(0).isOccupied());
        assertTrue("First row spots should remain occupied", matrix.getRow(0).getCell(0).isOccupied() && matrix.getRow(0).getCell(1).isOccupied());
    }
} 