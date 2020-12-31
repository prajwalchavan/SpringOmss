package com.project.omss;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.omss.entity.User;
import com.project.omss.repository.UserJpaRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class UserJpaRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserJpaRepository  userJpaRepository ;
	
	@Test
	public void testSaveAndUpdateUser() 
	{
		User user =new User();
		User savedInDb=entityManager.persist(user);
		User getFromDb=userJpaRepository.findByUserId(savedInDb.getUserId());
		
		assertThat(getFromDb).isEqualTo(savedInDb);
		
	}
	
	@Test
	public void testGetByUserById() 
	{
		User user=new User();
	    user.setUserId(4);
	    user.setFirstName("neha");
	    user.setLastName("kadam");
	    user.setMailId("neha123@gmail.com");
	    user.setMobileNo("9865741236");
	    user.setPassword("neha12");
	    
	    User savedInDb=entityManager.persist(user);
		User getFromDb=userJpaRepository.findByUserId(savedInDb.getUserId());
		assertThat(getFromDb).isEqualTo(savedInDb);
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
	    
	    entityManager.persist(user1);
	    entityManager.persist(user1);
	    
	    Iterable<User> allUserFromDb=userJpaRepository.findAll();
	    List<User>userList=new ArrayList<>();
	    
	    for(User user:allUserFromDb) 
	    {
	    	userList.add(user);
	    }
	    
	    assertThat(userList.size()).isGreaterThan(0);
	    
	}
}
