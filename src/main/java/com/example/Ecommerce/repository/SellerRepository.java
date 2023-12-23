package com.example.Ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ecommerce.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long>{

	public Optional<Seller> findBySellerName(String name);
}
