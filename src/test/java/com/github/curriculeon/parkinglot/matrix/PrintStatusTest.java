package com.github.curriculeon.parkinglot.matrix;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingMatrix;
import com.github.curriculeon.parkinglot.Size;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrintStatusTest {
    
    @Test
    public void testPrintEMPTYMatrix() {
        // Given
        final ParkingMatrix matrix = new ParkingMatrix(2, 3, Size.MEDIUM);
        
        // When
        final String status = matrix.getStatus();
        
        // Then
        assertEquals("EMPTY matrix should show all spots as EMPTY", 
            "Row 0: [EMPTY][EMPTY][EMPTY]\nRow 1: [EMPTY][EMPTY][EMPTY]",
            status);
    }

    @Test
    public void testPrintPartiallyOccupiedMatrix() {
        // Given
        final ParkingMatrix matrix = new ParkingMatrix(2, 3, Size.MEDIUM);
        final Car car1 = new Car(Size.SMALL);
        final Car car2 = new Car(Size.MEDIUM);
        matrix.parkCar(car1);
        matrix.parkCar(car2);
        
        // When
        final String status = matrix.getStatus();
        
        // Then
        assertEquals("Matrix should show occupied and EMPTY spots correctly", 
            "Row 0: [MEDIUM][MEDIUM][EMPTY]\nRow 1: [EMPTY][EMPTY][EMPTY]",
            status);
    }

    @Test
    public void testPrintFullMatrix() {
        // Given
        final ParkingMatrix matrix = new ParkingMatrix(2, 2, Size.MEDIUM);
        final Car car1 = new Car(Size.SMALL);
        final Car car2 = new Car(Size.MEDIUM);
        final Car car3 = new Car(Size.LARGE);
        final Car car4 = new Car(Size.SMALL);
        matrix.parkCar(car1);
        matrix.parkCar(car2);
        matrix.parkCar(car3);
        matrix.parkCar(car4);
        
        // When
        final String status = matrix.getStatus();
        
        // Then
        assertEquals("Full matrix should show all spots as occupied", 
            "Row 0: [MEDIUM][MEDIUM]\nRow 1: [MEDIUM][EMPTY]",
            status);
    }

    @Test
    public void testPrintMatrixWithDifferentSizes() {
        // Given
        final ParkingMatrix matrix = new ParkingMatrix(2, 3, Size.LARGE);
        final Car car1 = new Car(Size.SMALL);
        final Car car2 = new Car(Size.MEDIUM);
        final Car car3 = new Car(Size.LARGE);
        matrix.parkCar(car1);
        matrix.parkCar(car2);
        matrix.parkCar(car3);
        
        // When
        final String status = matrix.getStatus();
        
        // Then
        assertEquals("Matrix should show spots with different car sizes", 
            "Row 0: [LARGE][LARGE][LARGE]\nRow 1: [EMPTY][EMPTY][EMPTY]",
            status);
    }
} 