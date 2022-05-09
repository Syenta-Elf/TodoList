package com.elifnurtelase.TodoList.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoListTodoItemDto {
    private String title;
    private String description;
    private Boolean completed;
}
