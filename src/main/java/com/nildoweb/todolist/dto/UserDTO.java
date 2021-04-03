package com.nildoweb.todolist.dto;

import java.io.Serializable;

import com.nildoweb.todolist.domain.Todo;
import com.nildoweb.todolist.domain.User;

public class UserDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	
	
	public UserDTO() {
	}


	public UserDTO(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}


	public UserDTO(Todo x) {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}