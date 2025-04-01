package com.github.curriculeon.parkinglot.car;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.Size;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetSizeTest {
    @Test
    public void test() {
        for (Size size : Size.values()) {
            test(size);
        }
    }

    public void test(Size expectedSize) {
        // Given
        final Car car = new Car(expectedSize);

        // When
        final Size actualSize = car.getSize();

        // Then
        assertEquals("Car size should be LARGE", expectedSize, actualSize);
    }
} 