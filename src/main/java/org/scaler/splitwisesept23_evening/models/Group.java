package org.scaler.splitwisesept23_evening.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "user_groups")
public class Group extends BaseModel{
    private String name;
    @ManyToMany
    private List<User> members;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User admin;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}
