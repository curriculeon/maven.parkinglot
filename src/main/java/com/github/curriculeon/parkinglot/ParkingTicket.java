package com.github.curriculeon.parkinglot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingTicket {
    private final Car car;
    private final ParkingCell spot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private static final double SMALL_CAR_RATE = 2.0;
    private static final double MEDIUM_CAR_RATE = 3.0;
    private static final double LARGE_CAR_RATE = 4.0;

    public ParkingTicket(Car car, ParkingCell spot) {
        this.car = car;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
    }

    public Car getCar() {
        return car;
    }

    public ParkingCell getSpot() {
        return spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public long getDuration() {
        if (exitTime == null) {
            return ChronoUnit.MINUTES.between(entryTime, LocalDateTime.now());
        }
        return ChronoUnit.MINUTES.between(entryTime, exitTime);
    }

    public double getFee() {
        final long duration = getDuration();
        final double rate;
        switch (car.getSize()) {
            case SMALL:
                rate = SMALL_CAR_RATE;
                break;
            case MEDIUM:
                rate = MEDIUM_CAR_RATE;
                break;
            case LARGE:
                rate = LARGE_CAR_RATE;
                break;
            default:
                throw new IllegalStateException("Unexpected car size: " + car.getSize());
        }
        return duration * rate;
    }
}
