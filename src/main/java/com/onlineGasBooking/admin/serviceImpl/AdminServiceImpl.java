package com.onlineGasBooking.admin.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.onlineGasBooking.admin.dto.AdminDto;
import com.onlineGasBooking.admin.dto.BookingManagementResponseDto;
import com.onlineGasBooking.admin.dto.CustomerDto;
import com.onlineGasBooking.admin.dto.CylinderDTO;
import com.onlineGasBooking.admin.entity.Admin;
import com.onlineGasBooking.admin.entity.Cylinder;
import com.onlineGasBooking.admin.exception.AdminAlreadyExistsException;
import com.onlineGasBooking.admin.exception.AdminDoesNotExistException;
import com.onlineGasBooking.admin.exception.InvalidCredentialsException;
import com.onlineGasBooking.admin.repository.AdminRepo;
import com.onlineGasBooking.admin.service.AdminService;
import com.onlineGasBooking.admin.service.RemoteBookingService;
import com.onlineGasBooking.admin.service.RemoteCustomerService;
import com.onlineGasBooking.admin.service.RemoteCylinderService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adrp;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RemoteCylinderService rmcyl;
	
	@Autowired
	private RemoteCustomerService recus;
	
	@Autowired
	private RemoteBookingService rebo;
	
	@Override
	public AdminDto insertAdmin(AdminDto addto) throws AdminAlreadyExistsException {
		Optional<Admin> opt=adrp.findById(addto.getAdminId());
		if(opt.isPresent()) {
			throw new AdminAlreadyExistsException();
		}
		Admin a=mapper.map(addto, Admin.class);
		a.setUserPassword(passwordEncoder.encode(addto.getUserPassword()));
		return mapper.map(adrp.save(a), AdminDto.class);
	}

	@Override
	public AdminDto updateAdmin(AdminDto addto) throws AdminDoesNotExistException {
		Optional<Admin> opt=adrp.findById(addto.getAdminId());
		if(opt.isEmpty()) {
			throw new AdminDoesNotExistException();
		}
		Admin ad=opt.get();
		if(addto.getUserPassword()!=null && !ad.getUserPassword().equals(addto.getUserPassword())) {
			ad.setUserPassword(passwordEncoder.encode(addto.getUserPassword()));
		}
		else {
			throw new RuntimeException("Enter valid Password");
		}
		return mapper.map(adrp.save(ad), AdminDto.class);
	}

	@Override
	public List<CylinderDTO> getAllCylinders() {
		ResponseEntity<?> cyl=rmcyl.getAllCylinder();
		List<CylinderDTO> cyll=(List<CylinderDTO>) cyl.getBody();
		return cyll;
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		ResponseEntity<List<CustomerDto>> cus=recus.viewAllCustomer();
		return cus.getBody();
	}

	@Override
	public String loginAdmin(AdminDto addto) throws InvalidCredentialsException, AdminDoesNotExistException {
		Optional<Admin> opt=adrp.findByuserName(addto.getUserName());
		if(opt.isPresent()) {
			if(opt.get().getUserName().equals(addto.getUserName()) 
					&& (passwordEncoder.matches(addto.getUserPassword(), opt.get().getUserPassword()))) {
				return "Valid";
			}
			else {
				throw new InvalidCredentialsException();
			}
		}
		else {
			throw new AdminDoesNotExistException();
		}
//		Optional<Admin> a=adrp.findById(ad.getId());
//		if(a.isPresent()) {
//			if(a.get().getAdminPassword().equals(ad.getAdminPassword())) {
//				return "Login successfull";
//			}
//		}
//		return "Invalid Id or Password";
//		return null;
	}

	@Override
	public List<BookingManagementResponseDto> getAllDetails() {
		ResponseEntity<List<BookingManagementResponseDto>> book=rebo.getAllDetails();
		return book.getBody();
	}
	
	

}
