package com.abc.vegetable.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.vegetable.dto.LoginDTO;
import com.abc.vegetable.entity.*;
import com.abc.vegetable.exceptions.*;
import com.abc.vegetable.service.UserService;
import com.abc.vegetable.validation.*;

import java.util.*;


@RestController
@RequestMapping("/vegetables")
@CrossOrigin(origins= {"http://localhost:8080","http://localhost:60885"})
public class UserRestController
{

	@Autowired
	UserService userService;
	
	
	@GetMapping("/{Id}")
	public User getUser(@PathVariable int Id) {
		User obj =  userService.searchUser(Id);
		return obj;
	}
	
	@GetMapping("/users")
	public List<User> getallusers() {
		return userService.getalluserdetails();
	
	}
	
	@PostMapping("/user/login")
	public boolean doLogin(@RequestBody LoginDTO loginObj,HttpServletRequest req) throws InvalidUserException,InvalidUsernameOrPasswordException{
		String username = loginObj.getusername();
		String password = loginObj.getPassword();
		if(ValidateEntry.validateNull(username)&&ValidateEntry.validateNull(password)) {
			String role =  userService.login(username, password);
			if( userService.verifyforRegistration(username, password)) {
			
				if(role.equalsIgnoreCase("User"))
				{
				
					// generate new session 
					HttpSession session = req.getSession(true);
					
					session.setAttribute("role", role);
					session.setAttribute("username",username);
					session.setAttribute("password",password);
					
					return true;
					
				
				
				}
				else
				{
			
				throw new InvalidUserException("","");
				}
			
			  }
			else
			{
			
			throw new InvalidUsernameOrPasswordException(username,password);
			}
			
			
		}
		else
		{
		
			throw new InvalidUserException("","");
		}
	}
	@PostMapping("/user/loginadmin")
	public boolean doLogin1(@RequestBody LoginDTO loginObj,HttpServletRequest req) throws InvalidUserException,InvalidUsernameOrPasswordException{
		String username = loginObj.getusername();
		String password = loginObj.getPassword();
		if(ValidateEntry.validateNull(username)&&ValidateEntry.validateNull(password)) {
			String role =  userService.login(username, password);
			if( userService.verifyforRegistration(username, password)) {
			
				if(role.equalsIgnoreCase("Admin"))
				{
				
					// generate new session 
					HttpSession session = req.getSession(true);
					
					session.setAttribute("role", role);
					session.setAttribute("username",username);
					session.setAttribute("password",password);
					
					return true;
					
				
				
				}
				else
				{
			
				throw new InvalidUserException("","");
				}
			
			  }
			else
			{
			
			throw new InvalidUsernameOrPasswordException(username,password);
			}
			
			
		}
		else
		{
		
			throw new InvalidUserException("","");
		}
	}
	@PostMapping("/user/logout")
	public boolean doLogout(HttpServletRequest req)
	{
		HttpSession session = req.getSession(false);
		String role = (String)session.getAttribute("role");
		if(role.equalsIgnoreCase("User"))
		{
			session.invalidate(); // to logout
			return true;
		}
		else return false;
	}
	@PostMapping("/user/Registration")
	public String Registration(@RequestBody User u,HttpServletRequest req) {
		HttpSession Session = req.getSession(false);
		if(Session!=null) {
			if(Session.getAttribute("username").equals(u.getpassword()) || Session.getAttribute("password").equals(u.getpassword()) || Session.getAttribute("mobileNumber").equals(u.getmobileNumber())){ 
				
				return  "User already exists";
			}
			else
			{
				 userService.registrationProcess(u);
				return "Registration Successfull";
			}
		}
		else {
			 userService.registrationProcess(u);
			return "Registration Successfull";

			
		}
			
			
		
	}
}
