package model;

public class Slot {
    private int sloatNumber;
    private Car parkedCar;
    public Slot(final Integer slotNumber) {
        this.sloatNumber = slotNumber;
    }

    public Integer getSlotNumber() {
        return sloatNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public boolean isSlotFree() {
        return parkedCar == null;
    }

    public void assignCar(Car car) {
        this.parkedCar = car;
    }

    public void unassignCar() {
        this.parkedCar = null;
    }
}
