package com.abc.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.vegetable.entity.OrderTransactions;
import com.abc.vegetable.repository.*;
@Repository
public interface OrderTransactionRepository extends JpaRepository<OrderTransactions, Integer>{

}
