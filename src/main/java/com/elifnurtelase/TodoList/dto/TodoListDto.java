package com.elifnurtelase.TodoList.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TodoListDto {
    private TodoListUserDto todoListUserDto;
    private List<TodoListTodoItemDto> todoListTodoItems;
}
