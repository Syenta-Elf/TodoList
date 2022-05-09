package com.elifnurtelase.TodoList.service;

import com.elifnurtelase.TodoList.entity.TodoList;
import com.elifnurtelase.TodoList.entity.User;

public interface TodoListService {
    public TodoList createTodoList(User user);
}
