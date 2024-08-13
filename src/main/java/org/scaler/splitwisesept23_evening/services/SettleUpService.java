package org.scaler.splitwisesept23_evening.services;

import org.scaler.splitwisesept23_evening.models.Expense;
import org.scaler.splitwisesept23_evening.models.Group;
import org.scaler.splitwisesept23_evening.models.Transaction;
import org.scaler.splitwisesept23_evening.repositories.GroupRepository;
import org.scaler.splitwisesept23_evening.strategies.GeneralSettleUpStrategy;
import org.scaler.splitwisesept23_evening.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {
    @Autowired
    private GroupRepository groupRepository;
    private SettleUpStrategy settleUpStrategy;

    SettleUpService(SettleUpStrategy settleUpStrategy) {
        this.settleUpStrategy = new GeneralSettleUpStrategy();
    }

    public List<Transaction> settleUpGroup(
            Long groupId
    ){
        // 1. get the group from the database
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()) {
            throw new RuntimeException("Group Not found");
        }
        Group group = groupOptional.get();
        // 2. get the expenses from the group
        List<Expense> expenses = group.getExpenses();
        // 3. settle up using the expenses
        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);
        return transactions;
    }
}
