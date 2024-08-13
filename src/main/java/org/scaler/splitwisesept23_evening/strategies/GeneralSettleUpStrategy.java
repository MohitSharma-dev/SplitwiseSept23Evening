package org.scaler.splitwisesept23_evening.strategies;

import org.scaler.splitwisesept23_evening.models.Expense;
import org.scaler.splitwisesept23_evening.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneralSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        return List.of();
    }
}
