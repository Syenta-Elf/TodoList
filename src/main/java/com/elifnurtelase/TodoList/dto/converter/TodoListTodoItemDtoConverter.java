package com.elifnurtelase.TodoList.dto.converter;

import com.elifnurtelase.TodoList.dto.TodoListTodoItemDto;
import com.elifnurtelase.TodoList.entity.TodoItem;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TodoListTodoItemDtoConverter {
    private final ModelMapper modelMapper;
    
    public TodoListTodoItemDto convert(TodoItem from){
        TodoListTodoItemDto todoListTodoItemDto = modelMapper.map(from, TodoListTodoItemDto.class);
        return todoListTodoItemDto;
    }
}
