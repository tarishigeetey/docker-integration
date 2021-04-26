package com.ibm.boothello.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ibm.boothello.bean.Login;

@Repository
public class LoginRepository {
 
	private Map<String, Login> users;
	
	public LoginRepository() {
		users = new HashMap<String, Login>();
		users.put("duke", new Login("duke", "java"));
		users.put("polo", new Login("polo", "gems"));
	}
	
	public void addUser(Login login) {
		users.put(login.getUserid(), login);
	}
	
	public Login getUser(String userid) {
		return users.get(userid);
		
	}
	
	public Collection<Login> getAllUsers(){
		return users.values();
	}
}
