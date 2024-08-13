package org.scaler.splitwisesept23_evening;

import org.scaler.splitwisesept23_evening.command.CommandExecutor;
import org.scaler.splitwisesept23_evening.controllers.SettleUpController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseSept23EveningApplication implements CommandLineRunner {
    private SettleUpController settleUpController;
    private Scanner scanner = new Scanner(System.in);
    private CommandExecutor commandExecutor = new CommandExecutor();
    @Override
    public void run(String... args) throws Exception {
        // what all commands are there
        // how to parse input for each command
        // which controller to call for each command

        while(true){
            String input = scanner.nextLine();
            commandExecutor.execute(input);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseSept23EveningApplication.class, args);
    }

}
