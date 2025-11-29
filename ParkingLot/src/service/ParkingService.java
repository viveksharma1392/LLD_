package service;

import model.Car;
import model.ParkingLot;
import model.Slot;
import strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public ParkingService(final ParkingStrategy parkingStrategy, int capacity){
        this.parkingLot = new ParkingLot(capacity);
        this.parkingStrategy = parkingStrategy;
        for(int i =1; i <parkingLot.getCapacity()+1;i++){
            this.parkingStrategy.addSlot(i);
        }
    }

    public Integer park(final Car car){
        final Integer nextFreeSlotNumber = parkingStrategy.getNextSlot();
        parkingLot.park(car, nextFreeSlotNumber);
        parkingStrategy.removeSlot(nextFreeSlotNumber);
        return nextFreeSlotNumber;
    }

    public void makeSlotFree(final Integer slotNumber){
        parkingLot.makeSlotFree(slotNumber);
        parkingStrategy.addSlot(slotNumber);
    }

    public List<Slot> getOccupiedSlots(){
        Map<Integer, Slot> slots = parkingLot.getSlots();
        List<Slot> allOccupiedSlots = new ArrayList<>();
        for(Slot slot : slots.values()){
            if(!slot.isSlotFree()){
                allOccupiedSlots.add(slot);
            }
        }
        return  allOccupiedSlots;
    }

}
