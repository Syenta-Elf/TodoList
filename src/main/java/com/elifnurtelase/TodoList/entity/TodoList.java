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

    @OneToMany(mappedBy = "todoitem",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "todo_item_id")
    private List<TodoItem> todoItems;

    public TodoList(User user) {
        this.user = user;
    }
}
