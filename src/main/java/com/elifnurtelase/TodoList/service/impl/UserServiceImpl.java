package com.elifnurtelase.TodoList.service.impl;

import com.elifnurtelase.TodoList.dto.UserDto;
import com.elifnurtelase.TodoList.dto.converter.UserDtoConverter;
import com.elifnurtelase.TodoList.entity.TodoList;
import com.elifnurtelase.TodoList.entity.User;
import com.elifnurtelase.TodoList.repository.TodoListRepository;
import com.elifnurtelase.TodoList.repository.UserRepository;
import com.elifnurtelase.TodoList.service.TodoListService;
import com.elifnurtelase.TodoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private TodoListService todoListService;

    @Autowired
    private UserDtoConverter userDtoConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoListRepository todoListRepository;

    @Override
    public UserDto saveUser(User user) {
        TodoList todoList = todoListService.createTodoList(user);
        user.setTodoList(todoList);
        todoListRepository.save(user.getTodoList());
        userRepository.save(user);
    return userDtoConverter.convertEntity(user);

    }
    @Override
    public UserDto findUserById(Long id) {
       
        return userDtoConverter.convertEntity(userRepository.findById(id).get());
    }
    
}
