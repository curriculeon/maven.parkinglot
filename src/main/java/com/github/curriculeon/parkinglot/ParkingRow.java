package com.github.curriculeon.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingRow {
    private final List<ParkingCell> cells;

    public ParkingRow(List<ParkingCell> cells) {
        this.cells = new ArrayList<>(cells);
    }

    public ParkingRow(final int numCols, final Size size) {
        final List<ParkingCell> cellList = new ArrayList<>();
        for (int i = 0; i < numCols; i++) {
            cellList.add(new ParkingCell(size));
        }
        this.cells = cellList;
    }

    public boolean parkCar(Car car) {
        for (ParkingCell cell : cells) {
            if (cell.park(car)) {
                return true;
            }
        }
        return false;
    }

    public List<ParkingCell> getCells() {
        return cells;
    }

    public Car unparkCar(int colIndex) {
        return getCell(colIndex).unparkCar();
    }

    public ParkingCell getCell(int colIndex) {
        return getCells().get(colIndex);
    }
}