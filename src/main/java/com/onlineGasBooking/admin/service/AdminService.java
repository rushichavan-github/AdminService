package com.onlineGasBooking.admin.service;

import java.util.List;

import com.onlineGasBooking.admin.dto.AdminDto;
import com.onlineGasBooking.admin.dto.BookingManagementResponseDto;
import com.onlineGasBooking.admin.dto.CustomerDto;
import com.onlineGasBooking.admin.dto.CylinderDTO;
import com.onlineGasBooking.admin.entity.Cylinder;
import com.onlineGasBooking.admin.exception.AdminAlreadyExistsException;
import com.onlineGasBooking.admin.exception.AdminDoesNotExistException;
import com.onlineGasBooking.admin.exception.InvalidCredentialsException;

public interface AdminService {
	
	AdminDto insertAdmin(AdminDto addto) throws AdminAlreadyExistsException;
	
	AdminDto updateAdmin(AdminDto addto) throws AdminDoesNotExistException;
	
	List<CylinderDTO> getAllCylinders();
	
	List<CustomerDto> getAllCustomers();
	
	String loginAdmin(AdminDto ad) throws InvalidCredentialsException, AdminDoesNotExistException;
	
	List<BookingManagementResponseDto> getAllDetails();
}
