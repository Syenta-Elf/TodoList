package com.elifnurtelase.TodoList.dto;

import java.time.Instant;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TodoItemDto {
    private String title;
    private String description;
    private Boolean completed;
    private Instant createdAt = Instant.now();
    private Instant moddifiedAt = Instant.now();
}
