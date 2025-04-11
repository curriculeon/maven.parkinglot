package com.github.curriculeon.parkinglot;

public class Car {
    private final CarSize size;

    public Car(CarSize size) {
        this.size = size;
    }

    public CarSize getCarSize() {
        return size;
    }
} 