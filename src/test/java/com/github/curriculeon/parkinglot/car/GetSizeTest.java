package com.github.curriculeon.parkinglot.car;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.Size;
import org.junit.Test;
import static org.junit.Assert.*;

public class GetSizeTest {
    
    @Test
    public void testGetSmallCarSize() {
        // Given
        final Car car = new Car(Size.SMALL);
        
        // When
        final Size size = car.getSize();
        
        // Then
        assertEquals("Car size should be SMALL", Size.SMALL, size);
    }

    @Test
    public void testGetMediumCarSize() {
        // Given
        final Car car = new Car(Size.MEDIUM);
        
        // When
        final Size size = car.getSize();
        
        // Then
        assertEquals("Car size should be MEDIUM", Size.MEDIUM, size);
    }

    @Test
    public void testGetLargeCarSize() {
        // Given
        final Car car = new Car(Size.LARGE);
        
        // When
        final Size size = car.getSize();
        
        // Then
        assertEquals("Car size should be LARGE", Size.LARGE, size);
    }
} 