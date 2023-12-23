package com.example.Ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.entity.ItemMaster;

@Repository
public interface ItemRepository extends JpaRepository<ItemMaster,Long> {

	Optional<ItemMaster> findByOrderIdFKAndItemId(Long orderId,String itemId);
	
	List<ItemMaster> findByOrderIdFK(Long orderId);
}
