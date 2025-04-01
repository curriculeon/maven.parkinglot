package com.github.curriculeon.parkinglot;

public enum Size {
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private final int numberOfCells;

    Size(int numberOfCells) {
        this.numberOfCells = numberOfCells;
    }

    public boolean canFitIn(Size spotSize) {
        return this.numberOfCells <= spotSize.numberOfCells;
    }
} 