package com.elifnurtelase.TodoList.service.impl;

import com.elifnurtelase.TodoList.entity.TodoList;
import com.elifnurtelase.TodoList.entity.User;
import com.elifnurtelase.TodoList.repository.TodoListRepository;
import com.elifnurtelase.TodoList.service.TodoListService;

import org.springframework.stereotype.Service;

@Service

public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;
    @Override
    public TodoList createTodoList(User user) {
        
        return new TodoList(user);
    }
    

}
