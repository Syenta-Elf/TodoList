package com.elifnurtelase.TodoList.service;

import java.util.List;

import com.elifnurtelase.TodoList.dal.ServiceDAL;
import com.elifnurtelase.TodoList.dto.responseDTO.TodoResponseDTO;
import com.elifnurtelase.TodoList.dto.responseDTO.UserResponseDTO;
import com.elifnurtelase.TodoList.entity.Todo;
import com.elifnurtelase.TodoList.entity.User;
import com.elifnurtelase.TodoList.mapper.TodoMapper;
import com.elifnurtelase.TodoList.mapper.UserMapper;

import org.springframework.stereotype.Service;

@Service
public class UserTodoService {
    
    private final ServiceDAL serviceDAL;
    private final UserMapper userMapper;
    private final TodoMapper todoMapper;

    
    public UserTodoService(ServiceDAL serviceDAL, UserMapper userMapper, TodoMapper todoMapper) {
        this.serviceDAL = serviceDAL;
        this.userMapper = userMapper;
        this.todoMapper = todoMapper;
    }

    public UserResponseDTO addTodoItemToUser(Long userId,Todo todo){

        User user = serviceDAL.findUserById(userId);
        user.getTodoList().add(todo);
        serviceDAL.saveTodo(todo);
        serviceDAL.saveUser(user);
        return userMapper.toUserResponseDTO(user);
    }

    public UserResponseDTO removeTodoItemToUser(Long userId,Todo todo){
        User user = serviceDAL.findUserById(userId);
        user.getTodoList().remove(todo);
        serviceDAL.deleteTodo(todo.getId());
        serviceDAL.saveUser(user);
        return userMapper.toUserResponseDTO(user);
    }

    public UserResponseDTO updateTodoItemByIdToUser(Long userId,int index,Todo updateTodo){
        User user = serviceDAL.findUserById(userId);
        Todo todo = user.getTodoList().get(index);
        user.getTodoList().set(index, updateTodo);
        serviceDAL.updateTodo(todo.getId(),updateTodo);
        serviceDAL.saveUser(user);
        return userMapper.toUserResponseDTO(user);
    }

    public TodoResponseDTO findUserTodoItemByIndex(Long userId,int index){
        User user = serviceDAL.findUserById(userId);
        Todo todo = user.getTodoList().get(index);
        return todoMapper.todoResponseDTO(todo);
    }

    public List<TodoResponseDTO> findUserTodoItems(Long userId){
        User user = serviceDAL.findUserById(userId);
        List<TodoResponseDTO> todoList = user.getTodoList().stream().map(todo->todoMapper.todoResponseDTO(todo)).toList();
        return todoList;
    }
}
