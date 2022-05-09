package com.elifnurtelase.TodoList.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTodoListDto {
    private Long id;
    private List<TodoListTodoItemDto> todoItems;
}
