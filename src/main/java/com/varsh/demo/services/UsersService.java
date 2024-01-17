package com.varsh.demo.services;

import com.varsh.demo.entity.Users;

public interface UsersService {
     //to add user to db
	public String addUser(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email, String password);
	public String getRole(String email);
	public Users getUser(String email);
	public void updateUser(Users user);
}
