package model;

import exception.InvalidSlotException;
import exception.ParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static int MAX_CAPACITY = 10000;
    private int capacity;
    private Map<Integer, Slot> slotMap;

    public ParkingLot(final int capacity){
        if (capacity > MAX_CAPACITY || capacity <= 0) {
            throw new ParkingLotException("Invalid capacity given for parking lot.");
        }
        this.capacity = capacity;
        this.slotMap = new HashMap<>();
    }

    public int getCapacity(){
        return this.capacity;
    }

    public Map<Integer, Slot> getSlots(){
        return slotMap;
    }

    private void deleteSlot(Integer slotNumber){
        if(slotMap.containsKey(slotNumber)) {
            slotMap.remove(slotNumber);
        }
    }

    private Slot getSlot(Integer slotNumber){
        if(slotNumber>capacity || slotNumber<0){
            throw new InvalidSlotException();
        }
        final Map<Integer, Slot> allSlots = getSlots();
        if(!allSlots.containsKey(slotNumber)){
            allSlots.put(slotNumber, new Slot(slotNumber));
        }
        return allSlots.get(slotNumber);
    }

    public Slot park(final Car car, final Integer slotNumber){
        Slot slot = getSlot(slotNumber);
        if(!slot.isSlotFree()){
            throw new ParkingLotException("Slot is already occupied");
        }
        slot.assignCar(car);
        return slot;
    }

    public Slot makeSlotFree(final Integer slotNumber){
        final Slot slot = getSlot(slotNumber);
        deleteSlot(slotNumber);
        slot.unassignCar();
        return slot;
    }

}
