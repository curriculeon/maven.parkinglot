package com.github.curriculeon.parkinglot.size;

import com.github.curriculeon.parkinglot.Size;
import org.junit.Test;
import static org.junit.Assert.*;

public class CanFitInTest {
    
    @Test
    public void testSmallCanFitInSmall() {
        // Given
        final Size carSize = Size.SMALL;
        final Size spotSize = Size.SMALL;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Small car should fit in small spot", canFit);
    }

    @Test
    public void testSmallCanFitInMedium() {
        // Given
        final Size carSize = Size.SMALL;
        final Size spotSize = Size.MEDIUM;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Small car should fit in medium spot", canFit);
    }

    @Test
    public void testSmallCanFitInLarge() {
        // Given
        final Size carSize = Size.SMALL;
        final Size spotSize = Size.LARGE;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Small car should fit in large spot", canFit);
    }

    @Test
    public void testMediumCannotFitInSmall() {
        // Given
        final Size carSize = Size.MEDIUM;
        final Size spotSize = Size.SMALL;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertFalse("Medium car should not fit in small spot", canFit);
    }

    @Test
    public void testMediumCanFitInMedium() {
        // Given
        final Size carSize = Size.MEDIUM;
        final Size spotSize = Size.MEDIUM;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Medium car should fit in medium spot", canFit);
    }

    @Test
    public void testMediumCanFitInLarge() {
        // Given
        final Size carSize = Size.MEDIUM;
        final Size spotSize = Size.LARGE;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Medium car should fit in large spot", canFit);
    }

    @Test
    public void testLargeCannotFitInSmall() {
        // Given
        final Size carSize = Size.LARGE;
        final Size spotSize = Size.SMALL;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertFalse("Large car should not fit in small spot", canFit);
    }

    @Test
    public void testLargeCannotFitInMedium() {
        // Given
        final Size carSize = Size.LARGE;
        final Size spotSize = Size.MEDIUM;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertFalse("Large car should not fit in medium spot", canFit);
    }

    @Test
    public void testLargeCanFitInLarge() {
        // Given
        final Size carSize = Size.LARGE;
        final Size spotSize = Size.LARGE;
        
        // When
        final boolean canFit = carSize.canFitIn(spotSize);
        
        // Then
        assertTrue("Large car should fit in large spot", canFit);
    }
} 