package com.elifnurtelase.TodoList.dto.converter;

import com.elifnurtelase.TodoList.dto.UserDto;
import com.elifnurtelase.TodoList.entity.User;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserDtoConverter {

    private final ModelMapper modelMapper;

    public UserDto convertEntity(User from){
        UserDto userDto = modelMapper.map(from, UserDto.class);
        return userDto;
    }

    public User convertDto(UserDto from){
        User user = modelMapper.map(from, User.class);
        return user;
    }
    
    
}