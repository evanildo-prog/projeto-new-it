package com.nildoweb.todolist.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nildoweb.todolist.domain.Todo;
import com.nildoweb.todolist.repository.TodoRepository;



@Service
public class TodoService {

	@Autowired
	private TodoRepository repo;
	
	public Todo findById(String id) {
		Todo user = repo.findById(id).get();
		
		return user;
	}
	
	public List<Todo> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Todo> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}