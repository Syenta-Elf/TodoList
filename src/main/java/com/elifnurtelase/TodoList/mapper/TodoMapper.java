package com.elifnurtelase.TodoList.mapper;

import java.time.LocalDate;

import com.elifnurtelase.TodoList.dto.requestDTO.TodoRequestDTO;
import com.elifnurtelase.TodoList.dto.responseDTO.TodoResponseDTO;
import com.elifnurtelase.TodoList.entity.Todo;
import com.elifnurtelase.TodoList.repository.TodoRepository;

import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    
    private final TodoRepository todoRepository;

    public TodoMapper(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo toTodo(TodoRequestDTO todoRequestDTO){
        
        Todo todo = Todo.builder()
        .title(todoRequestDTO.getTitle())
        .description(todoRequestDTO.getDescription())
        .completed(false)
        .createdAt(LocalDate.now())
        .build();

        return todoRepository.save(todo);
    }

    public TodoResponseDTO todoResponseDTO(Todo todo){

        TodoResponseDTO todoResponseDTO = TodoResponseDTO.builder()
        .title(todo.getTitle())
        .description(todo.getDescription())
        .completed(todo.getCompleted())
        .build();

        return todoResponseDTO;
    }
}
