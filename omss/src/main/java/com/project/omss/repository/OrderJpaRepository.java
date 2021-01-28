package com.project.omss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.omss.entity.Order;

public interface OrderJpaRepository extends JpaRepository<Order, Integer> {

	List <Order> findByUserId(int userId);

}
