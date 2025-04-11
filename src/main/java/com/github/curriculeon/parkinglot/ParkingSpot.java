package com.github.curriculeon.parkinglot;

public class ParkingSpot {
    private final CarSize spotSize;
    private Car parkedCar;

    public ParkingSpot(final CarSize spotSize) {
        this.spotSize = spotSize;
        this.parkedCar = null;
    }

    public boolean canFit(final Car car) {
        return car.getCarSize().canFitIn(spotSize);
    }

    public boolean park(final Car car) {
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

    public CarSize getSpotSize() {
        return spotSize;
    }
} 