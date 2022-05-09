package com.elifnurtelase.TodoList.repository;

import com.elifnurtelase.TodoList.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem,Long> {
}
