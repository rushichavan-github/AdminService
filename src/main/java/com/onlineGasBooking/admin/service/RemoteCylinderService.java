package com.onlineGasBooking.admin.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineGasBooking.admin.entity.Cylinder;

@FeignClient(name="cylinder-service",url="http://localhost:8020/cylinderManagement")
public interface RemoteCylinderService {
	
//	@GetMapping("/getAllCylinders/{id}")
//	List<Cylinder> getAllCylinders();
	
	@GetMapping("/getAllCylinder")
	public ResponseEntity<?> getAllCylinder();
}
//http://localhost:8080/admin/getAllCylinders