package com.github.curriculeon.parkinglot;

public enum CarSize {
    SMALL,
    MEDIUM,
    LARGE;

    public boolean canFitIn(CarSize spotSize) {
        return this.ordinal() <= spotSize.ordinal();
    }
}