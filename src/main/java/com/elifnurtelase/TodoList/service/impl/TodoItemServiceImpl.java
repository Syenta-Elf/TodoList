package com.elifnurtelase.TodoList.service.impl;

import com.elifnurtelase.TodoList.dto.TodoItemDto;
import com.elifnurtelase.TodoList.dto.UserDto;
import com.elifnurtelase.TodoList.dto.converter.TodoItemDtoConverter;
import com.elifnurtelase.TodoList.dto.converter.UserDtoConverter;
import com.elifnurtelase.TodoList.entity.TodoItem;
import com.elifnurtelase.TodoList.entity.User;
import com.elifnurtelase.TodoList.repository.TodoItemRepository;
import com.elifnurtelase.TodoList.repository.TodoListRepository;
import com.elifnurtelase.TodoList.service.TodoItemService;
import com.elifnurtelase.TodoList.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoItemServiceImpl implements TodoItemService {
    @Autowired
    private TodoItemDtoConverter todoItemDtoConverter;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDtoConverter userDtoConverter;
    @Autowired
    private TodoItemRepository todoItemRepository;
    @Autowired
    private TodoListRepository todoListRepository;

    @Override
    public TodoItemDto saveTodoItem(TodoItem todoItem,Long userId) {

        UserDto userDto = userService.findUserById(userId);
        User user = userDtoConverter.convertDto(userDto);
        todoItem.setTodoList(todoListRepository.getById(userId));
        todoItemRepository.save(todoItem);
        userService.saveUser(user);
        return todoItemDtoConverter.convert(todoItem);
    }
}
