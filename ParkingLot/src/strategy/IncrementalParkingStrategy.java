package strategy;

import exception.NoFreeSlotException;

import java.util.TreeSet;

public class IncrementalParkingStrategy implements ParkingStrategy{
    private TreeSet<Integer> slotTreeSet;

    public IncrementalParkingStrategy(){
        this.slotTreeSet = new TreeSet<>();
    }


    @Override
    public void addSlot(Integer slotNumber) {
        this.slotTreeSet.add(slotNumber);
    }

    @Override
    public void removeSlot(Integer slotNumber) {
        this.slotTreeSet.remove(slotNumber);
    }

    @Override
    public Integer getNextSlot() {
        if(this.slotTreeSet.isEmpty()){
            throw new NoFreeSlotException();
        }
        return slotTreeSet.getFirst();
    }
}
