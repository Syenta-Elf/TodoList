package com.elifnurtelase.TodoList.service.impl;

import com.elifnurtelase.TodoList.dto.TodoItemDto;
import com.elifnurtelase.TodoList.dto.TodoListDto;
import com.elifnurtelase.TodoList.entity.TodoItem;
import com.elifnurtelase.TodoList.entity.TodoList;
import com.elifnurtelase.TodoList.repository.TodoItemRepository;
import com.elifnurtelase.TodoList.repository.TodoListRepository;
import com.elifnurtelase.TodoList.repository.UserRepository;
import com.elifnurtelase.TodoList.service.TodoItemService;
import com.elifnurtelase.TodoList.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoItemServiceImpl implements TodoItemService {

    private ModelMapper modelMapper;

    private UserService userService;
    @Autowired
    private TodoItemRepository todoItemRepository;
    @Autowired
    private TodoListRepository todoListRepository;

    private UserRepository userRepository;

    @Override
    public TodoItemDto saveTodoItem(TodoItem todoItem,Long id) {

        Optional<TodoList> todoList = todoListRepository.findById(id);

        todoList.get().getTodoItems().add(todoItem);
        todoItem.setTodoList(todoList.get());
        todoItemRepository.save(todoItem);
        todoListRepository.save(todoList.get());
        return modelMapper.map(todoItem,TodoItemDto.class);
    }
    @Override
    public TodoItemDto updateTodoItem(TodoItem todoItem,Long id,int todoItemIndex){
        Optional<TodoList> todoList = todoListRepository.findById(id);
        todoList.get().getTodoItems().get(todoItemIndex).setCompleted(todoItem.getCompleted());
        todoList.get().getTodoItems().get(todoItemIndex).setDescription(todoItem.getDescription());
        todoList.get().getTodoItems().get(todoItemIndex).setTitle(todoItem.getTitle());
        todoList.get().getTodoItems().get(todoItemIndex).setModdifiedAt(todoItem.getModdifiedAt());
        TodoItem updateTodoItem = todoList.get().getTodoItems().get(todoItemIndex);
        todoItemRepository.save(updateTodoItem);
        return modelMapper.map(updateTodoItem,TodoItemDto.class);
    }
}
