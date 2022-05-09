package com.elifnurtelase.TodoList.dto.converter;

import com.elifnurtelase.TodoList.dto.TodoListUserDto;
import com.elifnurtelase.TodoList.entity.User;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TodoListUserDtoConverter {
    private final ModelMapper modelMapper;

    public TodoListUserDto convert(User from){
        TodoListUserDto todoListUserDto = modelMapper.map(from, TodoListUserDto.class);
        return todoListUserDto;
    }

}
