# 🅿️ Java Parking Lot System

A fully object-oriented parking lot simulation built in Java. This system models real-world parking behavior using size-based constraints and a 2D parking matrix.

---

## 🚗 Car & Spot Size Rules

The parking system supports 3 sizes of cars and spots:

- `SMALL` (1 unit)
- `MEDIUM` (2 units)
- `LARGE` (3 units)

### Parking Fit Logic:
- A car can fit into a spot **if its `numberOfCells` ≤ the spot's `numberOfCells`**.
- This logic is encapsulated in the `Size` enum method:  
  ```java
  public boolean canFitIn(Size spotSize)
  ```

---

## 📦 Structure

| Class | Description |
|-------|-------------|
| `Size` | Enum defining `SMALL`, `MEDIUM`, and `LARGE` sizes and their capacities |
| `Car` | Represents a vehicle with a specific `Size` |
| `ParkingCell` | A parking space with a size and occupancy state |
| `ParkingRow` | A row of parking cells |
| `ParkingMatrix` | 2D grid of rows managing overall parking operations |

---

## ✅ Features

- ✅ Size-aware parking enforcement
- ✅ Simple parking algorithm (first-fit in matrix)
- ✅ `printStatus()` shows lot occupancy at a glance
- ✅ Fully modular and extendable for:
  - Floors
  - Parking tickets
  - Unparking and billing logic
  - Multi-threaded gate systems

---

## 🧪 Sample Usage

```java
ParkingCell c1 = new ParkingCell(Size.SMALL);
ParkingCell c2 = new ParkingCell(Size.MEDIUM);
ParkingCell c3 = new ParkingCell(Size.LARGE);

ParkingRow row1 = new ParkingRow(List.of(c1, c2, c3));
ParkingMatrix lot = new ParkingMatrix(List.of(row1));

Car small = new Car(Size.SMALL);
Car large = new Car(Size.LARGE);

lot.parkCar(small); // parks in SMALL
lot.parkCar(large); // parks in LARGE

lot.printStatus();  // Output: Row 0: [X][ ][X]
```

---

## 🛠️ Getting Started

1. Clone this repo:
   ```bash
   git clone https://github.com/yourusername/java-parking-lot.git
   cd java-parking-lot
   ```

2. Compile & Run:
   ```bash
   javac *.java
   java Main
   ```

> _Note: You can also open this in any Java IDE (e.g., IntelliJ, Eclipse, VS Code with Java extensions)._

---

## 📌 Future Improvements

- Add a `ParkingLot` class with multiple `ParkingMatrix` floors
- Implement `unpark()` with timestamps and payment logic
- Add a CLI or web interface to interact with the system

---

## 📄 License

MIT License – Feel free to fork, build, and extend this however you like.

---

### 👨‍💻 Created for OOP interview prep and design mastery.
