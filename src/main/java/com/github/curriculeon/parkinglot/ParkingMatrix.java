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


    public ParkingCell parkCar(Car car) {
        for (ParkingRow row : rows) {
            final ParkingCell parkingCell = row.parkCar(car);
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
}