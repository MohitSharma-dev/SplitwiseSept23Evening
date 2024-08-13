package org.scaler.splitwisesept23_evening.command;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    List<Command> commands;

    public CommandExecutor() {
        commands = new ArrayList<>();
        commands.add(new SettleUpGroupCommand());
    }

    public void add(Command command) {
        commands.add(command);
    }

    public void remove(Command command) {
        commands.remove(command);
    }

    public void execute(String input){
        for(Command command : commands) {
            if(command.matches(input)){
                command.execute(input);
            }
        }
    }
}
