package com.elifnurtelase.TodoList.controller;

import com.elifnurtelase.TodoList.dto.TodoItemDto;
import com.elifnurtelase.TodoList.entity.TodoItem;
import com.elifnurtelase.TodoList.service.TodoItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RequestMapping("/todoItem")
@RestController
@AllArgsConstructor
public class TodoItemController {
    
    private TodoItemService todoItemService;

    @PostMapping("/save")
    public ResponseEntity<TodoItemDto>saveTodoItem(@RequestBody TodoItem todoItem,@RequestParam Long userId){
        TodoItemDto todoItemDto = todoItemService.saveTodoItem(todoItem, userId);
        return ResponseEntity.ok(todoItemDto);
    }
}
