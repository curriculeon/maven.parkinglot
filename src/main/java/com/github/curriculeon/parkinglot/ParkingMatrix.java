package com.github.curriculeon.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingMatrix {
    private final List<ParkingRow> rows;

    public ParkingMatrix(List<ParkingRow> rows) {
        this.rows = new ArrayList<>(rows);
    }

    public ParkingMatrix(int numRows, int numCols, Size size) {
        final List<ParkingRow> rowList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rowList.add(new ParkingRow(numCols, size));
        }
        this.rows = rowList;
    }


    public boolean parkCar(Car car) {
        for (ParkingRow row : rows) {
            if (row.parkCar(car)) {
                return true;
            }
        }
        return false;
    }

    public String getStatus() {
        return this.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final ParkingRow row : rows) {
            for (final ParkingCell cell : row.getCells()) {
                sb.append(cell.isOccupied() ? "[" + cell.getSpotSize() + "]" : "[EMPTY]");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public ParkingRow getRow(final int i) {
        return rows.get(i);
    }
    public Car unparkCar(final int rowIndex, final int colIndex) {
        return getRow(rowIndex).unparkCar(colIndex);
    }
}