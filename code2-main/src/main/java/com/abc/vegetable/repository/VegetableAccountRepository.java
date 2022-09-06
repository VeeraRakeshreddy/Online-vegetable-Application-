package com.abc.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.abc.vegetable.entity.*;
@Repository
public interface VegetableAccountRepository extends JpaRepository<VegetableAccount, Integer>{

	

}
