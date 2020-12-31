package com.project.omss;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.omss.entity.User;
import com.project.omss.repository.UserJpaRepository;
import com.project.omss.service.UserServiceImpl;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
	@InjectMocks
	private UserServiceImpl userService;
	
	
	@MockBean
	private UserJpaRepository userRepo;
	
	@Ignore
	@Test
	public void testSaveAndUpdateUser() 
	{
		User user=new User();
	    user.setUserId(3);
	    user.setFirstName("neha");
	    user.setLastName("kadam");
	    user.setMailId("neha123@gmail.com");
	    user.setMobileNo("9865741236");
	    user.setPassword("neha12");
	    
	    Mockito.when(userRepo.save(user)).thenReturn(user);
	    assertThat(userService.saveOrUpdate(user)).isEqualTo(user);
		
	}
	
	@Test
	public void testGetByUserById() 
	{
		User user=new User();
	    user.setUserId(3);
	    user.setFirstName("neha");
	    user.setLastName("kadam");
	    user.setMailId("neha123@gmail.com");
	    user.setMobileNo("9865741236");
	    user.setPassword("neha12");
	    
	    Mockito.when(userRepo.findByUserId(3)).thenReturn(user);
	    assertThat(userService.findOneById(3)).isEqualTo(user);
	}
	
	
	@Test
	public void testGetAllUsers()
	{
		User user1=new User();
	    user1.setFirstName("neha");
	    user1.setLastName("kadam");
	    user1.setMailId("neha123@gmail.com");
	    user1.setMobileNo("9865741236");
	    user1.setPassword("neha12");
	    
	    User user2=new User();
	    user2.setFirstName("omkar");
	    user2.setLastName("kadam");
	    user2.setMailId("omkar123@gmail.com");
	    user2.setMobileNo("9865741456");
	    user2.setPassword("omkar12");
	    
	    List<User> user = new ArrayList<User>();
	    user.add(user1);
	    user.add(user2);
	    
	    Mockito.when(userRepo.findAll()).thenReturn(user);
	    assertThat(userService.getAllUsers()).isEqualTo(user);
	    
	}
	

}
