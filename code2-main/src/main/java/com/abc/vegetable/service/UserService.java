package com.abc.vegetable.service;

import org.springframework.stereotype.Service;

import com.abc.vegetable.entity.*;
import com.abc.vegetable.exceptions.*;

import java.util.*;

@Service
public interface UserService 
{
	public User searchUser(int Id);
	public String login(String username, String password) throws InvalidUserException;
	public boolean verifyforRegistration(String username,String password);
	public boolean registrationProcess(User u);
	public List<User> getalluserdetails();
}
