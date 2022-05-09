package com.elifnurtelase.TodoList.dto.converter;

import com.elifnurtelase.TodoList.dto.TodoItemDto;
import com.elifnurtelase.TodoList.entity.TodoItem;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TodoItemDtoConverter {
    private final ModelMapper modelMapper;

    public TodoItemDto convert(TodoItem from){
        TodoItemDto todoItemDto = modelMapper.map(from, TodoItemDto.class);
        return todoItemDto;
    }
}
