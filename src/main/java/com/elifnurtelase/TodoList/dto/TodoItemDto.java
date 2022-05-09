package com.elifnurtelase.TodoList.dto;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoItemDto {
    private String title;
    private String description;
    private Boolean completed;
    private Instant createdAt = Instant.now();
    private Instant moddifiedAt = Instant.now();
}
