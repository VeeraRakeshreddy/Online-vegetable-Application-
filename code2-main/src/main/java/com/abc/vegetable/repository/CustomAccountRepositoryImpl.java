package com.abc.vegetable.repository;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.abc.vegetable.exceptions.InvalidUserException;

public class CustomAccountRepositoryImpl implements CustomAccountRepository{

	@Autowired
	EntityManager jpa;
	
	@Override
	public String verifyUser(String username, String password){
		Session spring = jpa.unwrap(Session.class);
		
		String query = "select role from User u where username =:enteredusername and password =:enteredpassword";
		
		Query<String> q = spring.createQuery(query);
		q.setParameter("enteredusername", username);
		q.setParameter("enteredpassword", password);
		
		List<String> output =  q.getResultList();
		System.out.println(output);
		if(output.size()!=0) {
		return output.get(0); 
		}
		else
		{
			return null;
		}
			
		
		
		
	} 
	@Override
	public boolean verifyEntries(String username, String password) {
		Session spring = jpa.unwrap(Session.class);
		
		String query1 = "select username from User u where username=:enteredusername";
		String query2 = "select username from User u where password=:enteredpassword";
		Query<String> u = spring.createQuery(query1);
		Query<String> p = spring.createQuery(query2);
		u.setParameter("enteredusername", username);
		p.setParameter("enteredpassword", password);
		
		List<String> uOutput =  u.getResultList();
		List<String> pOutput =  p.getResultList();
		boolean status = false;
		if(uOutput.size()!=pOutput.size())
		{
			
			return status;
			
			
		}
		else
		{
			
			return status = true;
			
		}
		
	} 
	

}


