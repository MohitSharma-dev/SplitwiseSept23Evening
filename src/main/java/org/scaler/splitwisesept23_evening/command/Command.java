package org.scaler.splitwisesept23_evening.command;

public interface Command {
    boolean matches(String command);
    void execute(String command);
}
