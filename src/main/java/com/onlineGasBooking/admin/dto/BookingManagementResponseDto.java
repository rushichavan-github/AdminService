package com.onlineGasBooking.admin.dto;

import java.time.LocalDate;

public class BookingManagementResponseDto {
	private long bookingId;
	private long customerId;
	//private long cylinderId;
	private boolean status; 
	private float price ;
	private LocalDate bookingdate;
	private String address;
}
