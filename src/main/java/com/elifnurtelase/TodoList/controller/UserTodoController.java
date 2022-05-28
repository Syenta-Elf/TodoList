package com.elifnurtelase.TodoList.controller;

import java.util.List;

import com.elifnurtelase.TodoList.dto.responseDTO.TodoResponseDTO;
import com.elifnurtelase.TodoList.dto.responseDTO.UserResponseDTO;
import com.elifnurtelase.TodoList.entity.Todo;
import com.elifnurtelase.TodoList.service.UserTodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usertodo")
public class UserTodoController {
    
    private final UserTodoService userTodoService;

    public UserTodoController(UserTodoService userTodoService) {
        this.userTodoService = userTodoService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO> saveUserTodo(@RequestParam Long userId,@RequestBody Todo todo){

        UserResponseDTO userResponseDTO = userTodoService.addTodoItemToUser(userId, todo);
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/find")
    public ResponseEntity<TodoResponseDTO>findUserTodoById(@RequestParam Long userId,@RequestParam int todoItemIndex){
        TodoResponseDTO todoResponseDTO = userTodoService.findUserTodoItemByIndex(userId, todoItemIndex);
        return ResponseEntity.ok(todoResponseDTO);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TodoResponseDTO>>findUserTodoItems(@RequestParam Long userId){
        List<TodoResponseDTO> todoItems = userTodoService.findUserTodoItems(userId);
        return ResponseEntity.ok(todoItems);
    }

    
    //delete
    //update

}
