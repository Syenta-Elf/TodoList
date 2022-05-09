package com.elifnurtelase.TodoList.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "user_gen",sequenceName = "user_gen_seq",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_gen")
    private Long id;
    
    @Column(name="USER_NAME")
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "todo_list_id")
    private TodoList todoList;

    public User(String name) {
        this.name = name;
    }

    
}