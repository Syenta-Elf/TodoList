package com.elifnurtelase.TodoList.service;

import com.elifnurtelase.TodoList.dto.TodoItemDto;
import com.elifnurtelase.TodoList.entity.TodoItem;

public interface TodoItemService {
    public TodoItemDto saveTodoItem(TodoItem todoItem,Long userId);
    public TodoItemDto updateTodoItem(TodoItem todoItem,Long id,int todoItemIndex);
}
