package com.elifnurtelase.TodoList.service;

import com.elifnurtelase.TodoList.dto.UserDto;
import com.elifnurtelase.TodoList.entity.User;

public interface UserService {
    
    public UserDto saveUser(User user);
    public UserDto findUserById(Long id);
}
