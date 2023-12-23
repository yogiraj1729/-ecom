package com.example.Ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.entity.UserMaster;

@Repository
public interface UserRepository extends JpaRepository<UserMaster,Long>{

	Optional<UserMaster> findByUserName(String userName);
}
