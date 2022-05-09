package com.elifnurtelase.TodoList.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class TodoItem implements Serializable{
    @Id
    @SequenceGenerator(name = "todoItem_gen",sequenceName = "todoItem_seq",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "todoItem_gen")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="COMPLETED")
    private Boolean completed;

    @Column(name="CREATED_AT")
    private Instant createdAt = Instant.now();

    @Column(name="MODIFIED_AT")
    private Instant moddifiedAt = Instant.now();

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private TodoList todoList;

    public TodoItem(Long id, String title, String description, Boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }
}
