package com.abc.vegetable.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.vegetable.entity.OrderTransactions;
import com.abc.vegetable.service.OrderTransactionService;


@RestController
@RequestMapping("/orders")
@CrossOrigin(origins= {"http://localhost:8080","http://localhost:60885"})
public class OrderTransactionRestController {
	@Autowired
	OrderTransactionService orderservice;

	@GetMapping("/allorders")
	public List<OrderTransactions> getallOrderTransactions()
	{
		return orderservice.getallBookingTransactions();
	}
	
	
	
}
