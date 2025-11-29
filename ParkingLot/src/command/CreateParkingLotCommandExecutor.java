package command;

import model.Command;
import service.ParkingService;

import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(ParkingService parkingService){
        super(parkingService);
    }

    @Override
    public boolean validate(Command command) {
        final List<String> params = command.getParams();
        if(params.size()!=1){
            return false;
        }
        try {
            Integer.parseInt(params.getFirst());
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    @Override
    public void execute(Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getParams().getFirst());

    }
}
