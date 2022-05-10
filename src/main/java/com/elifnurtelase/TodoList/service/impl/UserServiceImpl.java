package com.elifnurtelase.TodoList.service.impl;

import com.elifnurtelase.TodoList.dto.UserDto;
import com.elifnurtelase.TodoList.entity.TodoList;
import com.elifnurtelase.TodoList.entity.User;
import com.elifnurtelase.TodoList.repository.TodoListRepository;
import com.elifnurtelase.TodoList.repository.UserRepository;
import com.elifnurtelase.TodoList.service.TodoListService;
import com.elifnurtelase.TodoList.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private ModelMapper modelMapper;

    @Autowired
    private TodoListService todoListService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoListRepository todoListRepository;

    @Override
    public UserDto saveUser(User user) {
        TodoList todoList = todoListService.createTodoList(user);
        user.setTodoList(todoList);
        userRepository.save(user);
        return modelMapper.map(user,UserDto.class);

    }
    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).get();
        return modelMapper.map(user,UserDto.class);
    }
    
}
