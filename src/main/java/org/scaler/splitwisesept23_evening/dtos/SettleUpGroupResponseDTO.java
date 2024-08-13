package org.scaler.splitwisesept23_evening.dtos;

import lombok.Getter;
import lombok.Setter;
import org.scaler.splitwisesept23_evening.models.Transaction;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDTO {
    private List<Transaction> transactionList;
    private ResponseStatus responseStatus;
}

// transactions : from , to : amt