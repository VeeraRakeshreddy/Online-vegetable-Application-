package com.abc.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.vegetable.entity.User;
import com.abc.vegetable.repository.*;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>,CustomAccountRepository
{

}