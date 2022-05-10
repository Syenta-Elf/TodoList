package com.elifnurtelase.TodoList.dto;

import java.util.List;

import lombok.Data;

@Data
public class TodoListDto {
    private List<TodoItemDto> todoItems;
}
