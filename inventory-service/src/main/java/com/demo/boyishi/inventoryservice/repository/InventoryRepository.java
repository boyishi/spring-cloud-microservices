package com.demo.boyishi.inventoryservice.repository;

import java.util.Optional;

import com.demo.boyishi.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	Optional<Inventory> findBySkuCode(String skuCode);
}
