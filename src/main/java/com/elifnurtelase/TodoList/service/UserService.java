package com.elifnurtelase.TodoList.service;

import java.util.List;
import java.util.stream.Collectors;

import com.elifnurtelase.TodoList.dal.ServiceDAL;
import com.elifnurtelase.TodoList.dto.requestDTO.UserRequestDTO;
import com.elifnurtelase.TodoList.dto.responseDTO.UserResponseDTO;
import com.elifnurtelase.TodoList.entity.User;
import com.elifnurtelase.TodoList.mapper.UserMapper;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final ServiceDAL serviceDAL;
    private final UserMapper userMapper;

    public UserService(ServiceDAL serviceDAL, UserMapper userMapper) {
        this.serviceDAL = serviceDAL;
        this.userMapper = userMapper;
    }

    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO){
        
        User user = userMapper.toUser(userRequestDTO);
        serviceDAL.saveUser(user);
        return userMapper.toUserResponseDTO(user);
    }

    public UserResponseDTO findUserById(Long userId){
        User user = serviceDAL.findUserById(userId);
        return userMapper.toUserResponseDTO(user);
    }

    public List<UserResponseDTO> findAllUsers(){
        return serviceDAL.findUsers().stream()
        .map(user->userMapper.toUserResponseDTO(user)).collect(Collectors.toList());
    }
    
    public UserResponseDTO updateUserById(UserRequestDTO userRequestDTO,Long userId){
        User updatedUser = serviceDAL.findUserById(userId);
        updatedUser = serviceDAL.updateUser(userId, userRequestDTO);
        return userMapper.toUserResponseDTO(updatedUser);
    }

    public UserResponseDTO deleteUserById(Long userId){
        UserResponseDTO userResponseDTO = findUserById(userId);
        serviceDAL.deleteUser(userId);
        return userResponseDTO;
    }
    
}
