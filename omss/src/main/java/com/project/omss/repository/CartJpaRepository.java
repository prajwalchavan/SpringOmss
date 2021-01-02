package com.project.omss.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.omss.entity.Cart;
import com.project.omss.entity.User;

public interface CartJpaRepository extends JpaRepository<Cart,Integer>{
	List<Cart> findByUserId(int userId);
	
	Cart findByProductId(int productId);
	
	@Query("delete from Cart u where u.userId=:userId")
	void deleteByUserId(@Param("userId") int userId);
	
}
