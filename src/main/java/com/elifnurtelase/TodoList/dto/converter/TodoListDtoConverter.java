package com.elifnurtelase.TodoList.dto.converter;

import com.elifnurtelase.TodoList.dto.TodoListDto;
import com.elifnurtelase.TodoList.entity.TodoList;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TodoListDtoConverter {

    private final ModelMapper modelMapper;

    public TodoListDto convert(TodoList from){
        TodoListDto todoListDto = modelMapper.map(from, TodoListDto.class);
        return todoListDto;
    }
}
