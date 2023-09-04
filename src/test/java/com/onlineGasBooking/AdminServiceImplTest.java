package com.onlineGasBooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.onlineGasBooking.admin.dto.AdminDto;
import com.onlineGasBooking.admin.entity.Admin;
import com.onlineGasBooking.admin.exception.AdminAlreadyExistsException;
import com.onlineGasBooking.admin.exception.AdminDoesNotExistException;
import com.onlineGasBooking.admin.repository.AdminRepo;
import com.onlineGasBooking.admin.serviceImpl.AdminServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AdminServiceImplTest {
	
	@Mock
	private AdminRepo adrp;
	
	@Mock
	private ModelMapper mapper;
	
	@Mock
	private PasswordEncoder passen;
	
	@InjectMocks
	private AdminServiceImpl adserv;
	
	
	@Test
	public void testAddAdmin() throws AdminAlreadyExistsException {

		AdminDto inputDto = new AdminDto();
        inputDto.setAdminId(23L);
        inputDto.setUserName("admin");
        inputDto.setUserPassword("rohit$321");
        Admin mappedCustomer = new Admin();
        Admin savedCustomer = new Admin();

        // Mock behavior for modelMapper
        when(mapper.map(inputDto, Admin.class)).thenReturn(mappedCustomer);

        // Mock behavior for custRepo
        when(adrp.save(mappedCustomer)).thenReturn(savedCustomer);

        // Mock behavior for modelMapper to map saved customer
        when(mapper.map(savedCustomer, AdminDto.class)).thenReturn(inputDto);

        // When
        AdminDto resultDto = adserv.insertAdmin(inputDto);

        // Then
        assertEquals(inputDto,resultDto);
        
	}
	
	@Test
	public void updateAdmin_exception() throws AdminDoesNotExistException{
		AdminDto admin = new AdminDto(52L,"admin","password");
		when(adrp.existsById((long) 52)).thenReturn(true);
		//AdminDto ad = adserv.updateAdmin(admin);
		Assertions.assertThrows(AdminDoesNotExistException.class,()-> adserv.updateAdmin(admin));
	}
}
