package com.github.curriculeon.parkinglot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParkingLot implements Iterable<ParkingRow> {
    private final List<ParkingRow> rows;

    public ParkingLot(final List<ParkingRow> rows) {
        this.rows = new ArrayList<>(rows);
    }

    public ParkingLot(final int numRows, final int numCols, final CarSize size) {
        final List<ParkingRow> rowList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rowList.add(new ParkingRow(numCols, size));
        }
        this.rows = rowList;
    }


    public ParkingSpot park(Car car) {
        for (final ParkingRow row : rows) {
            final ParkingSpot parkingCell = row.park(car);
            if (parkingCell != null) {
                return parkingCell;
            }
        }
        return null;
    }

    public String getStatus() {
        return this.toString();
    }

    @Override
    public String toString() {
        int rowNumber = 0;
        final StringBuilder sb = new StringBuilder();
        for (final ParkingRow row : rows) {
            sb.append("Row " + rowNumber++ + ": " + row.toString());
        }
        return sb.toString().replaceAll("\n$", "");
    }

    public ParkingRow getRow(final int i) {
        return rows.get(i);
    }
    public Car unparkCar(final int rowIndex, final int colIndex) {
        return getRow(rowIndex).unparkCar(colIndex);
    }

    @Override
    public Iterator<ParkingRow> iterator() {
        return rows.iterator();
    }
}