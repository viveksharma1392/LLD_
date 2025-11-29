package command;

import exception.InvalidCommandException;
import exception.NoFreeSlotException;
import model.Car;
import model.Command;
import model.Slot;
import service.ParkingService;

public class ParkCommandExecutor extends CommandExecutor {

    public static final String COMMAND_NAME = "park";

    public ParkCommandExecutor(final ParkingService parkingService){
        super(parkingService);
    }
    @Override
    public boolean validate(Command command) {
        return command.getParams().size()==2;
    }

    @Override
    public void execute(Command command) {
        final Car car =  new Car(command.getParams().get(0), command.getParams().get(1));
        try{
            final Integer slotNumber =  parkingService.park(car);
            System.out.println("car:: "+car.getRegistrationNumber()+" is parked at:: "+slotNumber);
        } catch (NoFreeSlotException exception){
            System.out.println("Parking is full");
        }
    }
}
