package com.github.curriculeon.parkinglot.car;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetSizeTest {
    @Test
    public void test() {
        for (CarSize size : CarSize.values()) {
            test(size);
        }
    }

    public void test(CarSize expectedSize) {
        // Given
        final Car car = new Car(expectedSize);

        // When
        final CarSize actualSize = car.getCarSize();

        // Then
        assertEquals("Car size should be LARGE", expectedSize, actualSize);
    }
} 