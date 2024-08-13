package org.scaler.splitwisesept23_evening.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;
    private int amount;
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> userExpenses;
    private String description;
    @ManyToOne
    private Group group;
}
