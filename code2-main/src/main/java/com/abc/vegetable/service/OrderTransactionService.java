package com.abc.vegetable.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.vegetable.entity.OrderTransactions;

@Service
public interface OrderTransactionService {
	public List<OrderTransactions>getallBookingTransactions();
	
}
