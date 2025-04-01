package com.github.curriculeon.parkinglot.cell;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingCell;
import com.github.curriculeon.parkinglot.Size;
import org.junit.Test;
import static org.junit.Assert.*;

public class CanFitTest {
    
    @Test
    public void testSmallCarInSmallSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.SMALL);
        final Car car = new Car(Size.SMALL);
        
        // When
        final boolean canFit = cell.canFit(car);
        
        // Then
        assertTrue("Small car should fit in small spot", canFit);
    }

    @Test
    public void testSmallCarInMediumSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.MEDIUM);
        final Car car = new Car(Size.SMALL);
        
        // When
        final boolean canFit = cell.canFit(car);
        
        // Then
        assertTrue("Small car should fit in medium spot", canFit);
    }

    @Test
    public void testSmallCarInLargeSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.LARGE);
        final Car car = new Car(Size.SMALL);
        
        // When
        final boolean canFit = cell.canFit(car);
        
        // Then
        assertTrue("Small car should fit in large spot", canFit);
    }

    @Test
    public void testMediumCarInSmallSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.SMALL);
        final Car car = new Car(Size.MEDIUM);
        
        // When
        final boolean canFit = cell.canFit(car);
        
        // Then
        assertFalse("Medium car should not fit in small spot", canFit);
    }

    @Test
    public void testMediumCarInMediumSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.MEDIUM);
        final Car car = new Car(Size.MEDIUM);
        
        // When
        final boolean canFit = cell.canFit(car);
        
        // Then
        assertTrue("Medium car should fit in medium spot", canFit);
    }

    @Test
    public void testMediumCarInLargeSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.LARGE);
        final Car car = new Car(Size.MEDIUM);
        
        // When
        final boolean canFit = cell.canFit(car);
        
        // Then
        assertTrue("Medium car should fit in large spot", canFit);
    }

    @Test
    public void testLargeCarInSmallSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.SMALL);
        final Car car = new Car(Size.LARGE);
        
        // When
        final boolean canFit = cell.canFit(car);
        
        // Then
        assertFalse("Large car should not fit in small spot", canFit);
    }

    @Test
    public void testLargeCarInMediumSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.MEDIUM);
        final Car car = new Car(Size.LARGE);
        
        // When
        final boolean canFit = cell.canFit(car);
        
        // Then
        assertFalse("Large car should not fit in medium spot", canFit);
    }

    @Test
    public void testLargeCarInLargeSpot() {
        // Given
        final ParkingCell cell = new ParkingCell(Size.LARGE);
        final Car car = new Car(Size.LARGE);
        
        // When
        final boolean canFit = cell.canFit(car);
        
        // Then
        assertTrue("Large car should fit in large spot", canFit);
    }
} 