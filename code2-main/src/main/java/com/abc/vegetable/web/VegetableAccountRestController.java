package com.abc.vegetable.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abc.vegetable.dto.LoginDTO;
import com.abc.vegetable.entity.*;
import com.abc.vegetable.repository.VegetableAccountRepository;

import com.abc.vegetable.service.VegetableAccountService;
import com.abc.vegetable.validation.ValidateEntry;
import com.abc.vegetable.repository.*;
import com.abc.vegetable.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vegetable")
@CrossOrigin(origins= {"http://localhost:8080","http://localhost:60885"})
public class VegetableAccountRestController {
	@Autowired
	VegetableAccountService vegetableAccountService;
	@Autowired
	private VegetableAccountRepository vegetableAccountRepository; 
	
	
	@GetMapping("/allvegetable")
	public List<VegetableAccount> doThis()
	{
		return vegetableAccountService.getAllvegetable();
	}
	@GetMapping("/vegetablefromHtoL")
	public List<VegetableAccount> vegetablefromHtoL()
	{
		return vegetableAccountService.filterByCostHtoL();
	}
	@GetMapping("/vegetablebyRating")
	public List<VegetableAccount> vegetablebyRating()
	{
		return vegetableAccountService.filterByRating();
	}
	@GetMapping("/vegetablefromLtoH")
	public List<VegetableAccount> pizzafromLtoH()
	{
		return vegetableAccountService.filterByCostLtoH();
	}
	
	
	@PostMapping("/add") 
	public String savedAccountFromWeb(@RequestBody VegetableAccount a)
	{
		boolean status =vegetableAccountService.insertvegetable(a);
	
		return status == true?"Vegetable Added ":"Contact to customer Care";
	}
	@DeleteMapping("/vegetables/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteVegetable(@PathVariable Integer id){
		VegetableAccount vegetable = vegetableAccountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("vegetable not exist with id :" + id));
		
		vegetableAccountRepository.delete(vegetable);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@PutMapping("/vegetables/{id}")
	public ResponseEntity<VegetableAccount> updateVegetable(@PathVariable Integer id, @RequestBody VegetableAccount vegetableDetails){
		VegetableAccount vegetable = vegetableAccountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("vegetable not exist with id :" + id));
		vegetable.setvegetableName(vegetableDetails.getvegetableName());
		vegetable.setvegetableAmount(vegetableDetails.getvegetableAmount());
		vegetable.setvegetableType(vegetableDetails.getvegetableType());
		
		VegetableAccount updatedVegetable = vegetableAccountRepository.save(vegetable);
		return ResponseEntity.ok(updatedVegetable);
	}
	@GetMapping("/vegetables/{id}")
	public ResponseEntity<VegetableAccount> getvegetableById(@PathVariable Integer id) {
		VegetableAccount vegetable = vegetableAccountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vegetable not exist with id :" + id));
		return ResponseEntity.ok(vegetable);
	}
	
}