package com.onlineGasBooking.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineGasBooking.admin.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long>{
	public Optional<Admin> findByuserName(String userName);
}
