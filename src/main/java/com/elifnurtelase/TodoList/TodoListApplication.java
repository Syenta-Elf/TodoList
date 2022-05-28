package com.elifnurtelase.TodoList;

import java.util.ArrayList;

import com.elifnurtelase.TodoList.dal.ServiceDAL;
import com.elifnurtelase.TodoList.entity.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListApplication implements CommandLineRunner {

	private final ServiceDAL serviceDAL;
	public TodoListApplication(ServiceDAL serviceDAL) {
		this.serviceDAL = serviceDAL;
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = User.builder()
		.firstName("berk")
		.lastName("asd")
		.todoList(new ArrayList<>())
		.build();

		User user2 = User.builder()
		.firstName("sualp")
		.lastName("qwer")
		.todoList(new ArrayList<>())
		.build();

		User user3 = User.builder()
		.firstName("kek")
		.lastName("zxcv")
		.todoList(new ArrayList<>())
		.build();
		
		serviceDAL.saveUser(user1);
		serviceDAL.saveUser(user2);
		serviceDAL.saveUser(user3);
		
	}

}
