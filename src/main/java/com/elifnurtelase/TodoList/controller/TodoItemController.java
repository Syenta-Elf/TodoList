package com.elifnurtelase.TodoList.controller;

import com.elifnurtelase.TodoList.dto.TodoItemDto;
import com.elifnurtelase.TodoList.entity.TodoItem;
import com.elifnurtelase.TodoList.service.TodoItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RequestMapping("/todoItem")
@RestController
@AllArgsConstructor
public class TodoItemController {

    private TodoItemService todoItemService;

    @PutMapping("/save")
    public ResponseEntity<TodoItemDto> saveTodoItem(@RequestBody TodoItem todoItem, @RequestParam Long userId) {
        TodoItemDto todoItemDto = todoItemService.saveTodoItem(todoItem, userId);
        return ResponseEntity.ok(todoItemDto);
    }

    @PostMapping("/update")
    public ResponseEntity<TodoItemDto> updateTodoItem(@RequestBody TodoItem todoItem, @RequestParam Long id, @RequestParam int index) {
        TodoItemDto todoItemDto = todoItemService.updateTodoItem(todoItem, id, index);
        return ResponseEntity.ok(todoItemDto);
    }
}
