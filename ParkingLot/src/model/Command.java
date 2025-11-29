package model;

import exception.InvalidCommandException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private static final String DELIMITER = " ";
    private String commandName;
    private List<String> params;

    public String getCommandName(){
        return commandName;
    }

    public List<String> getParams(){
        return params;
    }

    public Command(String inputLine){
        params = Arrays.stream(inputLine.trim().split(DELIMITER))
                .map(String::trim)
                .filter(token-> (!token.isEmpty())).collect(Collectors.toList());
        if (params.isEmpty()){
            throw new InvalidCommandException();
        }
        commandName = params.getFirst().toLowerCase();
        params.removeFirst();
    }
}
