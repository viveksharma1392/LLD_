package command;

import model.Command;
import service.ParkingService;

public abstract class CommandExecutor {
    protected ParkingService parkingService;

    public CommandExecutor(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    public abstract boolean validate(Command command);

    public abstract void execute(Command command);

}
