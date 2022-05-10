package com.elifnurtelase.TodoList.service;

import com.elifnurtelase.TodoList.dto.TodoItemDto;
import com.elifnurtelase.TodoList.entity.TodoList;
import com.elifnurtelase.TodoList.entity.User;

import java.util.List;

public interface TodoListService {
    public TodoList createTodoList(User user);
    public List<TodoItemDto> listUserTodoItems(Long id);


}
