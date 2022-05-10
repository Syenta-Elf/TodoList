package com.elifnurtelase.TodoList.service.impl;

import com.elifnurtelase.TodoList.dto.TodoItemDto;
import com.elifnurtelase.TodoList.entity.TodoItem;
import com.elifnurtelase.TodoList.entity.TodoList;
import com.elifnurtelase.TodoList.entity.User;
import com.elifnurtelase.TodoList.repository.TodoListRepository;
import com.elifnurtelase.TodoList.service.TodoListService;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoListServiceImpl implements TodoListService{

    private ModelMapper modelMapper;
    private TodoListRepository todoListRepository;
    @Override
    public TodoList createTodoList(User user) {
        TodoList todoList = new TodoList(user);
        List<TodoItem> todoItems = new ArrayList<>();
        todoList.setTodoItems(todoItems);
        return todoListRepository.save(todoList);
    }

    @Override
    public List<TodoItemDto> listUserTodoItems(Long id) {
        List<TodoItemDto> todoItemDtoList = todoListRepository.findById(id).get().getTodoItems().stream()
                .map(item->modelMapper.map(item,TodoItemDto.class))
                .collect(Collectors.toList());

        return todoItemDtoList;
    }


}
