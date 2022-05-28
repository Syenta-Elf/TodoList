package com.elifnurtelase.TodoList.controller;

import com.elifnurtelase.TodoList.dto.requestDTO.UserRequestDTO;
import com.elifnurtelase.TodoList.dto.responseDTO.UserResponseDTO;
import com.elifnurtelase.TodoList.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.saveUser(userRequestDTO);        
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/findById")
    public ResponseEntity<UserResponseDTO> findUserById(@RequestParam Long userId){
        UserResponseDTO userResponseDTO = userService.findUserById(userId);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserRequestDTO userRequestDTO,Long userId){
        UserResponseDTO userResponseDTO = userService.updateUserById(userRequestDTO, userId);
        return ResponseEntity.ok(userResponseDTO);
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUserById(@RequestParam Long userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok("deleted");
    }  
}
