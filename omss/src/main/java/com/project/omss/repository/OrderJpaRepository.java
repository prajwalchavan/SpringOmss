package com.project.omss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.omss.entity.Order;

public interface OrderJpaRepository extends JpaRepository<Order, Integer> {

}
