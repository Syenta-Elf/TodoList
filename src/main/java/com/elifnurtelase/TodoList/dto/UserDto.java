package com.elifnurtelase.TodoList.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private UserTodoListDto userTodoListDto;
}
