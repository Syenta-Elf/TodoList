package com.elifnurtelase.TodoList.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TodoList {
    @Id
    @SequenceGenerator(name = "todoItemList_gen",sequenceName = "todoItemList_seq",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "todoItemList_gen")
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private List<TodoItem> todoItems = null;

    public TodoList(User user) {
        this.user = user;
    }

    public TodoList() {

    }
}
