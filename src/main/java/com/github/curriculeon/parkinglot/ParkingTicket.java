package com.github.curriculeon.parkinglot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingTicket {
    private final Car car;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public ParkingTicket(Car car, ParkingSpot spot) {
        this.car = car;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
    }

    public Car getCar() {
        return car;
    }

    public ParkingSpot getSpot() {
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
        return car.getCarSize().getRate() * getDuration();
    }
}
