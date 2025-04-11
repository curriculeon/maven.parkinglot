package com.github.curriculeon.parkinglot.cell;

import com.github.curriculeon.parkinglot.Car;
import com.github.curriculeon.parkinglot.ParkingSpot;
import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CanFitTest {
    @Test
    public void testSmallCarFitsInAllSpots() {
        test(CarSize.SMALL, CarSize.SMALL, CarSize.MEDIUM, CarSize.LARGE);
    }

    @Test
    public void testMediumCarFitsInMediumAndLargeSpots() {
        test(CarSize.MEDIUM, CarSize.MEDIUM, CarSize.LARGE);
    }

    @Test
    public void testLargeCarFitsOnlyInLargeSpot() {
        test(CarSize.LARGE, CarSize.LARGE);
    }

    private void test(final CarSize sizeOfCarToTest, final CarSize... validCarSizesForParking) {
        for (CarSize cellSize : CarSize.values()) {
            // Given
            final ParkingSpot cell = new ParkingSpot(cellSize);
            final Car car = new Car(sizeOfCarToTest);

            // When
            final boolean canFit = cell.canFit(car);

            // Then
            boolean expectedFit = Arrays.asList(validCarSizesForParking).contains(cellSize);
            assertEquals(
                    String.format("%s car %s fit in %s spot", sizeOfCarToTest,
                            expectedFit ? "should" : "should not", cellSize),
                    expectedFit, canFit
            );
        }
    }

} 