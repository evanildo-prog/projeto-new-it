package com.nildoweb.todolist.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nildoweb.todolist.domain.Todo;
import com.nildoweb.todolist.domain.User;

@Repository
public interface TodoRepository extends MongoRepository<User, String> {

	Object findById = null;

	List<Todo> fullSearch(String text, Date minDate, Date maxDate);

	

}
