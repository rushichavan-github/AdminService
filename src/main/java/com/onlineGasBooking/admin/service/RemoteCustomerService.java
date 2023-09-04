package com.onlineGasBooking.admin.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.onlineGasBooking.admin.dto.CustomerDto;


@FeignClient(name="customer-service",url="http://localhost:8030/customer")
public interface RemoteCustomerService {
	
	@GetMapping("/customersList")
	public ResponseEntity<List<CustomerDto>> viewAllCustomer();
}
