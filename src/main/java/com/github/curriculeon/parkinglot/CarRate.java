package com.github.curriculeon.parkinglot;

public enum CarRate {
    SMALL(2.0),
    MEDIUM(3.0),
    LARGE(4.0);

    private final double value;

    CarRate(final double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}