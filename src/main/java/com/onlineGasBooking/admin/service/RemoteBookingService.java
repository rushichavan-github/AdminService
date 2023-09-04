package com.onlineGasBooking.admin.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.onlineGasBooking.admin.dto.BookingManagementResponseDto;



@FeignClient(name="booking-service",url="http://localhost:8040/bookingManagement")
public interface RemoteBookingService {
	@GetMapping("/getAllDetails")
	public ResponseEntity<List<BookingManagementResponseDto>> getAllDetails();
}
