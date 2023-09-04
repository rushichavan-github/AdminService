package com.onlineGasBooking.admin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
	private Long adminId;
	
	@NotBlank(message="Username cannot be blank")
	private String userName;
	@NotBlank(message="Password cannot be blank")
	@Size(min=3,max=30,message="Password characters must be between 3 to 15")
	private String userPassword;
	
	
}
