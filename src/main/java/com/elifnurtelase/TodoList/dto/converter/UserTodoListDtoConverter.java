package com.elifnurtelase.TodoList.dto.converter;

import com.elifnurtelase.TodoList.dto.UserTodoListDto;
import com.elifnurtelase.TodoList.entity.TodoList;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserTodoListDtoConverter {
    private final ModelMapper modelMapper;

    public UserTodoListDto convert(TodoList from){

        UserTodoListDto userTodoListDto = modelMapper.map(from, UserTodoListDto.class);
        return userTodoListDto;
    }
}
