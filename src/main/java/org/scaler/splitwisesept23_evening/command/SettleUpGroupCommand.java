package org.scaler.splitwisesept23_evening.command;

import org.scaler.splitwisesept23_evening.controllers.SettleUpController;
import org.scaler.splitwisesept23_evening.dtos.ResponseStatus;
import org.scaler.splitwisesept23_evening.dtos.SettleUpGroupRequestDTO;
import org.scaler.splitwisesept23_evening.dtos.SettleUpGroupResponseDTO;
import org.scaler.splitwisesept23_evening.models.Transaction;

import java.util.List;

public class SettleUpGroupCommand implements Command {
    private SettleUpController settleUpController;
    @Override
    public boolean matches(String command) {
        List<String> words = List.of(command.split(" "));
        return words.get(0).equals("SettleUpGroup") && words.size() == 2;
    }

    @Override
    public void execute(String command) {
        List<String> words = List.of(command.split(" "));
        Long groupId = Long.parseLong(words.get(1));

        SettleUpGroupRequestDTO requestDTO = new SettleUpGroupRequestDTO();
        requestDTO.setGroupId(groupId);
        SettleUpGroupResponseDTO response = settleUpController.settleUpGroup(requestDTO);
        if(response.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println("Something went wrong");
        } else {
            for(Transaction transaction : response.getTransactionList()){
                System.out.println(transaction.getFrom().getName() + " should pay " + transaction.getAmount() + " to " + transaction.getTo().getName());
            }
        }
    }
}
