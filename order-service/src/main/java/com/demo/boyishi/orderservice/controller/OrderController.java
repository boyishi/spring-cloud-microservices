package com.demo.boyishi.orderservice.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.boyishi.orderservice.client.InventoryClient;
import com.demo.boyishi.orderservice.dto.OrderDto;
import com.demo.boyishi.orderservice.model.Order;
import com.demo.boyishi.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
	
	InventoryClient inventoryClient;
	OrderRepository orderRepository;
	
	@PostMapping
	public String placeOrder(@RequestBody OrderDto orderDto) {
		boolean productsInStock = orderDto.getOrderLineItemsList().stream()
		        .allMatch(lineItem -> {
		            log.info("Making Call to Inventory Service for SkuCode {}", lineItem.getSkuCode());
		            try {
		                return inventoryClient.checkStock(lineItem.getSkuCode());
		            } catch (Exception e) {
		                // Handle the error case here
		                handleErrorCase();
		                return false;
		            }
		        });
		
		if (productsInStock) {
			Order order = new Order();
			order.setOrderLineItems(orderDto.getOrderLineItemsList());
			order.setOrderNumber(UUID.randomUUID().toString());
			
			orderRepository.save(order);
			log.info("Sending Order Details with Order Id {} to Notification Service", order.getId());
			return "Order placed successfully";
		} else {
			return "Order Failed - One of the Product in your Order is out of stock";
		}
	}
	
	private Boolean handleErrorCase() {
		return false;
	}
}
