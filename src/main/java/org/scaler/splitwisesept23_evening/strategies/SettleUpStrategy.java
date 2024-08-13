package org.scaler.splitwisesept23_evening.strategies;

import org.scaler.splitwisesept23_evening.models.Expense;
import org.scaler.splitwisesept23_evening.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);
}
