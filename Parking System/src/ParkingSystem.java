public class ParkingSystem {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10);
        pl.parkCar(1);
        pl.displayParkingLot(pl.parking_lot);
    }
}

class ParkingLot {
    public int slots;
    public String[] parking_lot;
    public boolean isFree;

    public ParkingLot(int slots) {
        this.slots = slots;
        this.parking_lot = new String[slots];
    }

    void displayParkingLot(String[] parking_lot) {
        for (int i = 0; i < parking_lot.length; i++) {
            if (parking_lot[i] == null) {
                System.out.println("Slot " + (i + 1) + " is free");
            } else {
                System.out.println("Slot " + (i + 1) + " is occupied");
            }
        }
    }

    void parkCar(int licensePlate) {
        for (int i = 0; i < slots; i++) {
            if (parking_lot[i] == null) {
                parking_lot[i] = String.valueOf(licensePlate);
                System.out.println("Car parked! at slot" + (i + 1));
                return;
            }
        }
        System.out.println("No space available!");
    }

    void removeCar(int licensePlate) {
        for (int i = 0; i < parking_lot.length; i++) {
            if (parking_lot[i] == String.valueOf(licensePlate)) {
                parking_lot[i] = null;
                System.out.println("Car removed! from slot" + (i + 1));
            }
        }
        System.out.println("Car not found!");
    }

}