package com.varsh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varsh.demo.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	public Users findByEmail(String email);

}
