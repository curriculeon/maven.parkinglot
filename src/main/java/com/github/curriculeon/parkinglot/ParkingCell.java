package com.github.curriculeon.parkinglot;

public class ParkingCell {
    private final Size spotSize;
    private Car parkedCar;

    public ParkingCell(Size spotSize) {
        this.spotSize = spotSize;
        this.parkedCar = null;
    }

    public boolean canFit(Car car) {
        return car.getSize().canFitIn(spotSize);
    }

    public boolean park(Car car) {
        if (!isOccupied() && canFit(car)) {
            parkedCar = car;
            return true;
        }
        return false;
    }

    public Car unparkCar() {
        final Car car = parkedCar;
        if (isOccupied()) {
            parkedCar = null;
        }
        return car;
    }

    public boolean isOccupied() {
        return parkedCar != null;
    }

    public Size getSpotSize() {
        return spotSize;
    }
} 