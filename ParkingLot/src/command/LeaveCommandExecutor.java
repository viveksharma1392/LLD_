package command;

import model.Command;
import service.ParkingService;

import java.util.List;

public class LeaveCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME = "leave";
    public LeaveCommandExecutor(final ParkingService parkingService){
        super(parkingService);
    }

    @Override
    public boolean validate(Command command) {
        final List<String> params = command.getParams();
        if (params.size() != 1) {
            return false;
        }
        try{
            Integer.parseInt(params.getFirst());
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public void execute(Command command) {
        final int slotNum = Integer.parseInt(command.getParams().get(0));
        parkingService.makeSlotFree(slotNum);
        System.out.println("Slot number " + slotNum + " is free");
    }
}
