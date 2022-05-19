package com.elifnurtelase.TodoList.dal;

import java.util.List;

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
        return todoRepository.save(todo);
    }
    // Save Methods <-- FINISH -->

    // Update Methods <-- START -->
    public User updateUser(User user) {
        User updatedUser = User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();

        return saveUser(updatedUser);
    }

    public Todo updateTodo(Todo todo) {
        Todo updatedTodo = Todo.builder()
                .id(todo.getId())
                .completed(todo.getCompleted())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .build();

        return saveTodo(updatedTodo);
    }
    // Update Methods <-- FINISH -->

    // Delete Methods <-- START -->
    public User deleteUser(User user) {
        userRepository.delete(user);
        return user;
    }

    public Todo deleteTodo(Todo todo) {
        todoRepository.delete(todo);
        return todo;
    }
    // Delete Methods <-- FINISH -->

    // FindAll Methods <-- START -->
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public List<Todo> findTodos(){
        return todoRepository.findAll();
    }

    public List<Todo> findUserTodos(Long userId){
        
        return userRepository.getById(userId).getTodoList();
    }
    // Find Methods <-- FINISH -->
}
