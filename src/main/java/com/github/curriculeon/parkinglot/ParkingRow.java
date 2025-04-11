package com.github.curriculeon.parkinglot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParkingRow implements Iterable<ParkingCell> {
    private final List<ParkingCell> cells;

    public ParkingRow(List<ParkingCell> cells) {
        this.cells = new ArrayList<>(cells);
    }

    public ParkingRow(final int numCols, final CarSize size) {
        final List<ParkingCell> cellList = new ArrayList<>();
        for (int i = 0; i < numCols; i++) {
            cellList.add(new ParkingCell(size));
        }
        this.cells = cellList;
    }

    public ParkingCell park(Car car) {
        for (ParkingCell cell : cells) {
            if (cell.park(car)) {
                return cell;
            }
        }
        return null;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final ParkingCell cell : this.getCells()) {
            sb.append(cell.isOccupied() ? "[" + cell.getSpotSize() + "]" : "[EMPTY]");
        }
        return sb.append("\n").toString();
    }

    @Override
    public Iterator<ParkingCell> iterator() {
        return cells.iterator();
    }
}