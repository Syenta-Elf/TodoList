package com.elifnurtelase.TodoList.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "GEN_TODO")
    @Column(name = "ID")
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDate createdAt;

}
