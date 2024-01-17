package com.varsh.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varsh.demo.entity.Users;
import com.varsh.demo.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
		
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
		
	}

	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "User added Succesfully";
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email) == null)
			return false;
		else
			return true;
		
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user = repo.findByEmail(email);
		if(user == null)
			return false;
		else
			return password.equals(user.getPassword());
		
		
	}

	@Override
	public String getRole(String email) {
		Users user = repo.findByEmail(email);
		return user.getRole();
	}
	
	
	
	
}
