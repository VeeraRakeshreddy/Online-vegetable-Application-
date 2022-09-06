package com.abc.vegetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.vegetable.entity.*;
import com.abc.vegetable.exceptions.InvalidUserException;
import com.abc.vegetable.repository.UserRepository;

import java.util.*;
@Service
public class UserServiceImpl  implements UserService
{
	@Autowired
	UserRepository userRepository;

	@Override
	public User searchUser(int Id) {
		User u = userRepository.findById(Id).get();
		return u;
		
	}
	@Override
	public List<User> getalluserdetails()
	{
		return userRepository.findAll();
	}
	@Override
	public String login(String username, String password)throws InvalidUserException
	{
		
		String role = userRepository.verifyUser(username, password);
		
		return role;
	}

	public boolean verifyforRegistration(String username,String password) {
		if(userRepository.verifyEntries(username, password)== true) {
			return true;
		}
		else 
		{
			return false;
		}
		
		
	}
	public boolean registrationProcess(User u){
		userRepository.save(u);
		return true;
	}
	
	
}
