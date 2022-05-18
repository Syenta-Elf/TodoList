package com.elifnurtelase.TodoList.repository;

import com.elifnurtelase.TodoList.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
