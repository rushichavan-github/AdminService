package com.onlineGasBooking.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineGasBooking.admin.dto.AdminDto;
import com.onlineGasBooking.admin.dto.BookingManagementResponseDto;
import com.onlineGasBooking.admin.dto.CustomerDto;
import com.onlineGasBooking.admin.dto.CylinderDTO;
import com.onlineGasBooking.admin.entity.Cylinder;
import com.onlineGasBooking.admin.exception.AdminAlreadyExistsException;
import com.onlineGasBooking.admin.exception.AdminDoesNotExistException;
import com.onlineGasBooking.admin.exception.InvalidCredentialsException;
import com.onlineGasBooking.admin.service.AdminService;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService adserv;
	
	Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	@PostMapping("/add")
	public ResponseEntity<?> insertAdmin(@RequestBody AdminDto addto) throws AdminAlreadyExistsException{
		logger.info("saved admin details");
		return new ResponseEntity<AdminDto>(adserv.insertAdmin(addto),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable Long id,@RequestBody AdminDto addto) throws AdminDoesNotExistException{
		addto.setAdminId(id);
		logger.info("updates admin details");
		return new ResponseEntity<AdminDto>(adserv.updateAdmin(addto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllCylinders")
	public List<CylinderDTO> getAllCylinders(){
		logger.info("Got all cylinder details");
		return adserv.getAllCylinders();
	}
	
	@GetMapping("/getAllCustomers")
	public List<CustomerDto> getAllCustomers(){
		logger.info("Got all customer details");
		return adserv.getAllCustomers();
	}
	
	@GetMapping("/loginAdmin")
	public String loginAdmin(AdminDto ad) throws InvalidCredentialsException, AdminDoesNotExistException {
		logger.info("Login!");
		return adserv.loginAdmin(ad);
	}
	
	@GetMapping("/getAllDetails")
	public List<BookingManagementResponseDto> getAllDetails(){
		logger.info("Got all booking details");
		return adserv.getAllDetails();
	}
	
	
}
