package com.ibm.boothello.rest;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.boothello.bean.Login;
import com.ibm.boothello.repo.LoginRepository;

@RestController
public class LoginContoller {

	@Autowired
	private LoginRepository repo;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public String addUser(@RequestBody Login login) {
		repo.addUser(login);
		return "User Added";
	}
	
	@GetMapping(value = "/users", produces = "application/json")
	public Collection<Login> getUsers(){
		return repo.getAllUsers();
	}
	
	@GetMapping(value = "/user/{id}", produces = "application/json")
	public Login getUser(@PathVariable("id") String userid) {
		return repo.getUser(userid);
	}
}
