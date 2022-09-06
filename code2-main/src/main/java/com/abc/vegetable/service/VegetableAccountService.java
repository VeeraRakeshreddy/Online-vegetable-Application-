package com.abc.vegetable.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.abc.vegetable.entity.VegetableAccount;
import com.abc.vegetable.exceptions.InvalidUserException;


@Service

public interface VegetableAccountService 
{
	
	public List<VegetableAccount> getAllvegetable();
	public List<VegetableAccount> filterByCostHtoL();
	public List<VegetableAccount> filterByCostLtoH();	
	public boolean insertvegetable(VegetableAccount p);
	public VegetableAccount searchvegetable(int pizzaId);

	public List<VegetableAccount> filterByRating();
	
}