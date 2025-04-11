package com.github.curriculeon.parkinglot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParkingRow implements Iterable<ParkingSpot> {
    private final List<ParkingSpot> parkingSpots;

    public ParkingRow(final List<ParkingSpot> parkingSpots) {
        this.parkingSpots = new ArrayList<>(parkingSpots);
    }

    public ParkingRow(final int numCols, final CarSize size) {
        final List<ParkingSpot> parkingSpotList = new ArrayList<>();
        for (int i = 0; i < numCols; i++) {
            parkingSpotList.add(new ParkingSpot(size));
        }
        this.parkingSpots = parkingSpotList;
    }

    public ParkingSpot park(final Car car) {
        for (final ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.park(car)) {
                return parkingSpot;
            }
        }
        return null;
    }

    public List<ParkingSpot> getCells() {
        return parkingSpots;
    }

    public Car unparkCar(final int colIndex) {
        return getCell(colIndex).unparkCar();
    }

    public ParkingSpot getCell(final int colIndex) {
        return getCells().get(colIndex);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final ParkingSpot parkingSpot : this.getCells()) {
            sb.append(parkingSpot.isOccupied() ? "[" + parkingSpot.getSpotSize() + "]" : "[EMPTY]");
        }
        return sb.append("\n").toString();
    }

    @Override
    public Iterator<ParkingSpot> iterator() {
        return parkingSpots.iterator();
    }
}