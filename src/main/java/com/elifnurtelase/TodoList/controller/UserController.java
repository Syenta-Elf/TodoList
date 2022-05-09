package com.elifnurtelase.TodoList.controller;

import com.elifnurtelase.TodoList.dto.UserDto;
import com.elifnurtelase.TodoList.entity.User;
import com.elifnurtelase.TodoList.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;
    @PostMapping("/save")
    public ResponseEntity<UserDto> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){

        return ResponseEntity.ok(userService.findUserById(id));
    }
}
