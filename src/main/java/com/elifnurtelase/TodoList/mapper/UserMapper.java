package com.elifnurtelase.TodoList.mapper;

import java.util.ArrayList;

import com.elifnurtelase.TodoList.dto.requestDTO.UserRequestDTO;
import com.elifnurtelase.TodoList.dto.responseDTO.UserResponseDTO;
import com.elifnurtelase.TodoList.entity.User;
import com.elifnurtelase.TodoList.repository.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final UserRepository userRepository;
    private final TodoMapper todoMapper;
    
    public UserMapper(UserRepository userRepository, TodoMapper todoMapper) {
        this.userRepository = userRepository;
        this.todoMapper = todoMapper;
    }

    public User toUser(UserRequestDTO userRequestDTO){
        User user = User.builder()
        .firstName(userRequestDTO.getFirstName())
        .lastName(userRequestDTO.getLastName())
        .todoList(new ArrayList<>())
        .build();

        return userRepository.save(user);
    }

    public UserResponseDTO toUserResponseDTO(User user){
        UserResponseDTO userResponseDTO = UserResponseDTO.builder()
        .id(user.getId())
        .firstName(user.getFirstName())
        .todoList(user.getTodoList().stream().map(todo->todoMapper.todoResponseDTO(todo)).toList())
        .build();

        return userResponseDTO;
    }
}
