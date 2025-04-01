package com.github.curriculeon.parkinglot.size;

import com.github.curriculeon.parkinglot.CarSize;
import org.junit.Test;
import static org.junit.Assert.*;

public class CanFitInTest {
    
    @Test
    public void testSmallCanFitInSmall() {
        // Given
        final CarSize carSize = CarSize.SMALL;
        final CarSize spotSize = CarSize.SMALL;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Small car should fit in small spot", canFit);
    }

    @Test
    public void testSmallCanFitInMedium() {
        // Given
        final CarSize carSize = CarSize.SMALL;
        final CarSize spotSize = CarSize.MEDIUM;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Small car should fit in medium spot", canFit);
    }

    @Test
    public void testSmallCanFitInLarge() {
        // Given
        final CarSize carSize = CarSize.SMALL;
        final CarSize spotSize = CarSize.LARGE;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Small car should fit in large spot", canFit);
    }

    @Test
    public void testMediumCannotFitInSmall() {
        // Given
        final CarSize carSize = CarSize.MEDIUM;
        final CarSize spotSize = CarSize.SMALL;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertFalse("Medium car should not fit in small spot", canFit);
    }

    @Test
    public void testMediumCanFitInMedium() {
        // Given
        final CarSize carSize = CarSize.MEDIUM;
        final CarSize spotSize = CarSize.MEDIUM;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Medium car should fit in medium spot", canFit);
    }

    @Test
    public void testMediumCanFitInLarge() {
        // Given
        final CarSize carSize = CarSize.MEDIUM;
        final CarSize spotSize = CarSize.LARGE;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Medium car should fit in large spot", canFit);
    }

    @Test
    public void testLargeCannotFitInSmall() {
        // Given
        final CarSize carSize = CarSize.LARGE;
        final CarSize spotSize = CarSize.SMALL;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertFalse("Large car should not fit in small spot", canFit);
    }

    @Test
    public void testLargeCannotFitInMedium() {
        // Given
        final CarSize carSize = CarSize.LARGE;
        final CarSize spotSize = CarSize.MEDIUM;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertFalse("Large car should not fit in medium spot", canFit);
    }

    @Test
    public void testLargeCanFitInLarge() {
        // Given
        final CarSize carSize = CarSize.LARGE;
        final CarSize spotSize = CarSize.LARGE;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Large car should fit in large spot", canFit);
    }
} 