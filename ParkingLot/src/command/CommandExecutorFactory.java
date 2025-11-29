package command;

import exception.InvalidCommandException;
import model.Command;
import service.ParkingService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final ParkingService parkingLotService) {
        commands.put(
                CreateParkingLotCommandExecutor.COMMAND_NAME,
                new CreateParkingLotCommandExecutor(parkingLotService));
        commands.put(
                ParkCommandExecutor.COMMAND_NAME,
                new ParkCommandExecutor(parkingLotService));
        commands.put(
                LeaveCommandExecutor.COMMAND_NAME,
                new LeaveCommandExecutor(parkingLotService));
    }

    /**
     * Gets {@link CommandExecutor} for a particular command. It basically uses name of command to
     * fetch its corresponding executor.
     *
     * @param command Command for which executor has to be fetched.
     * @return Command executor.
     */
    public CommandExecutor getCommandExecutor(final Command command) {
        final CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
    }
}
