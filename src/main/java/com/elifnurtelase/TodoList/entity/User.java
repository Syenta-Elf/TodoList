package com.elifnurtelase.TodoList.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "GEN_USER")
    @Column(name = "ID")
    private Long id;
    
    private String firstName;
    private String lastName;
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Todo> todoList;

}
