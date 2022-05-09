package com.elifnurtelase.TodoList.repository;

import com.elifnurtelase.TodoList.entity.TodoList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {
    
}
