package com.elifnurtelase.TodoList.dal;

import java.time.LocalDate;
import java.util.List;

import com.elifnurtelase.TodoList.dto.requestDTO.UserRequestDTO;
import com.elifnurtelase.TodoList.entity.Todo;
import com.elifnurtelase.TodoList.entity.User;
import com.elifnurtelase.TodoList.repository.TodoRepository;
import com.elifnurtelase.TodoList.repository.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class ServiceDAL {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public ServiceDAL(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    // Save Methods <-- START -->
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Todo saveTodo(Todo todo) {
        todo.setCreatedAt(LocalDate.now());
        if(todo.getCompleted()==null){
            todo.setCompleted(false);
        }
        return todoRepository.save(todo);
    }
    // Save Methods <-- FINISH -->

    // Update Methods <-- START -->
    public User updateUser(Long userId,UserRequestDTO updatedUser) {
        User user = userRepository.getById(userId);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        return userRepository.save(user);
    }

    public Todo updateTodo(Long todoId,Todo updatedTodo) {
        Todo t = todoRepository.getById(todoId);
        t.setTitle(updatedTodo.getTitle());
        t.setDescription(updatedTodo.getDescription());
        t.setCompleted(updatedTodo.getCompleted());
        return saveTodo(t);
    }
    // Update Methods <-- FINISH -->

    // Delete Methods <-- START -->
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
    // Delete Methods <-- FINISH -->

    // FindAll Methods <-- START -->
    public User findUserById(Long userId) {
        return userRepository.getById(userId);
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public List<Todo> findTodos() {
        return todoRepository.findAll();
    }

    public List<Todo> findUserTodos(Long userId) {

        return userRepository.getById(userId).getTodoList();
    }
    // Find Methods <-- FINISH -->
}
