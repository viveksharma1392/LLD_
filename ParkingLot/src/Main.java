import command.CommandExecutor;
import command.CommandExecutorFactory;
import exception.InvalidCommandException;
import model.Command;
import service.ParkingService;
import strategy.IncrementalParkingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        final ParkingService parkingLotService = new ParkingService(new IncrementalParkingStrategy(), 5);
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            final String input = reader.readLine();
            final Command command = new Command(input);
            final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
            if (commandExecutor.validate(command)) {
                commandExecutor.execute(command);
            } else {
                throw new InvalidCommandException();
            }
        }
    }
}