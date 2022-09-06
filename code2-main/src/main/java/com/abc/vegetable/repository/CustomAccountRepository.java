package com.abc.vegetable.repository;

import com.abc.vegetable.exceptions.InvalidUserException;

public interface CustomAccountRepository {
	
	public String verifyUser(String username,String password)/*throws InvalidUserException*/;
	public boolean verifyEntries(String username, String password) ;

}