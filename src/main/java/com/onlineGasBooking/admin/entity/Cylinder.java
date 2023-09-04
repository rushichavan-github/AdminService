package com.onlineGasBooking.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cylinder {
	@Id
	private Long cylinderId;
    private String type;
    private float weight;
    private float price;
}
