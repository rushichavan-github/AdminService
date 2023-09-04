package com.onlineGasBooking.admin.dto;



//import org.hibernate.validator.constraints.NotEmpty;

//import com.onlineGasBooking.dto.CylinderDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CylinderDTO {
	private Long cylinderId;
    @Size(min = 2, max = 20)
	private String type;
	@NotEmpty
	private float weight;
	@NotEmpty
	private float price;
}


