package com.abc.vegetable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.vegetable.entity.*;
import com.abc.vegetable.repository.OrderTransactionRepository;




@Service
public class OrderTransactionServiceImpl implements OrderTransactionService{
	@Autowired
	OrderTransactionRepository orderRepository;
	

	@Override
	public List<OrderTransactions> getallBookingTransactions() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}
	
}
